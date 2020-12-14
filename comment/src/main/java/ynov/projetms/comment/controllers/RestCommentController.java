package ynov.projetms.comment.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ynov.projetms.comment.model.Comment;
import ynov.projetms.comment.repositories.CommentRepository;

public class RestCommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("/comment")
	public Iterable<Comment> getComments(){
		Iterable<Comment> comments = commentRepository.findAll();
		return comments;
	}
	
	@GetMapping("/comment/article/{id}")
	public Iterable<Comment> getArticleComments(@PathVariable("id") int id){
		Iterable<Comment> comments = commentRepository.findAllByArticleId(id);
		return comments;
	}
	
	@GetMapping("/comment/{id}")
	public Optional<Comment> getComment(@PathVariable("id") int id){
		Optional<Comment> comment = commentRepository.findById(id);
		return comment;
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
