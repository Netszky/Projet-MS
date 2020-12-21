package ynov.projetms.comment.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ynov.projetms.comment.model.Comment;
import ynov.projetms.comment.model.User;
import ynov.projetms.comment.repositories.UserProxy;

@Component
public class CommentTransformer {
	@Autowired
	private UserProxy userProxy;
	
	public CommentR transform(Comment c) {
		CommentR commentR = new CommentR();
		
		commentR.setId(c.getId());
		commentR.setContent(c.getContent());
		commentR.setPost_date(c.getPost_date());
		commentR.setOn_article_id(c.getOn_article_id());
		User user = userProxy.getUser(c.getUser_id());
		commentR.setUser(user);
		
		return commentR;
	}
}
