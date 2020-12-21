package ynov.projectms.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import ynov.projectms.webClient.CustomProperties;
import ynov.projectms.webClient.model.Comment;

@Repository
public class CommentProxy extends GenericProxy{
	@Autowired
	private CustomProperties props;
	
	public Comment getComment(int id) {
		String getCommentUrl = props.getApiUrl() +"/comment/" + id;
		ResponseEntity<Comment> response = restTemplate.exchange(
				getCommentUrl, 
				HttpMethod.GET, 
				null, 
				Comment.class);
			return response.getBody();
	}
	
	public Iterable<Comment> getArticles(){
		String getArticleUrl = props.getApiUrl() + "/comment";
		ResponseEntity<Iterable<Comment>> response = restTemplate.exchange(
				getArticleUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<Comment>>() {});
		return response.getBody();
	}
	
	public Comment createComment(Comment comment) {
		String createArticleUrl = props.getApiUrl() + "/article";
		
		HttpEntity<Comment> requestEntity = new HttpEntity<Comment>(comment);
		ResponseEntity<Comment> response = restTemplate.exchange(
				createArticleUrl, 
				HttpMethod.POST, 
				requestEntity, 
				Comment.class);
		
		return response.getBody();
	}
	public Comment updateComment(Comment comment) {
		String updateCommentUrl = props.getApiUrl() + "/comment/" + comment.getId();
		HttpEntity<Comment> requestEntity = new HttpEntity<Comment>(comment);
		ResponseEntity<Comment> response = restTemplate.exchange(
				updateCommentUrl, 
				HttpMethod.PUT, 
				requestEntity, 
				Comment.class);
		
		return response.getBody();
	}
	public void deleteComment(Integer id) {
		String deleteCommentUrl = props.getApiUrl() + "/comment/" + id;
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteCommentUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		System.out.println(response.getStatusCode().toString());
		
	}
}
