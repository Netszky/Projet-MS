package ynov.projetms.article.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import ynov.projetms.article.config.CustomProperties;
import ynov.projetms.article.dto.Comment;

@Repository
public class CommentProxy {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CustomProperties props;
	
	public Comment getComment(int id) {
		String getCommentUrl = props.getApiUrl() + "/comment/" + id;
		ResponseEntity<Comment> response = restTemplate.exchange(
				getCommentUrl, 
				HttpMethod.GET, 
				null, 
				Comment.class);
		return response.getBody();
	}
}
