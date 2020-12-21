package ynov.projetms.comment.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ynov.projetms.comment.dto.CommentR;
import ynov.projetms.comment.dto.CommentTransformer;
import ynov.projetms.comment.model.Comment;
import ynov.projetms.comment.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CommentTransformer commentTransformer;
	
	public CommentR getComment(int id) {
		Comment comment = commentRepository.findById(id).get();
		CommentR commentR = commentTransformer.transform(comment);
		return commentR;
	}
	public Iterable<CommentR> getComments(int id){
		Iterable<Comment> comments = commentRepository.findAllByArticleId(id);
		ArrayList<CommentR> commentRs = new ArrayList<CommentR>();
		
		Iterator<Comment> iterator = comments.iterator();
		while(iterator.hasNext()) {
			Comment c = iterator.next();
			CommentR commentR = commentTransformer.transform(c);
			commentRs.add(commentR);
		}
		return commentRs;
	}
}
