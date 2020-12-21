package ynov.projetms.comment.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import ynov.projetms.comment.config.CustomProperties;
import ynov.projetms.comment.model.User;

@Repository
public class UserProxy {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private CustomProperties props;
	
	public User getUser(int id) {
		String getUserUrl = props.getApiUrl() + "/user/" + id;
		ResponseEntity<User> response = restTemplate.exchange(
			getUserUrl, 
			HttpMethod.GET, 
			null, 
			User.class);
		return response.getBody();
	}
}
