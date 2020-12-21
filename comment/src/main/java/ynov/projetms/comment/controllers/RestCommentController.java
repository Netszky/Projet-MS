package ynov.projetms.comment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetms.comment.dto.CommentR;
import ynov.projetms.comment.model.Comment;
import ynov.projetms.comment.repositories.CommentRepository;
import ynov.projetms.comment.service.CommentService;

@RestController
public class RestCommentController {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private CommentService commentService; 
	
	@GetMapping("/comment/article/{id}")
	public Iterable<CommentR> getArticleComments(@PathVariable int id){
		return commentService.getComments(id);
	}
	
	@GetMapping("/comment/{id}")
	public CommentR getComment(@PathVariable int id){
		return commentService.getComment(id);
	}
	
	@PostMapping("/comment")
	public Comment createComment(@RequestBody Comment comment) {
		comment = commentRepository.save(comment);
		return comment;
	}
	
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable("id") int id) {
		commentRepository.deleteById(id);
	}
	
}
