package ynov.projectms.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import ynov.projectms.webClient.CustomProperties;
import ynov.projectms.webClient.model.User;

@Repository
public class UserProxy extends GenericProxy{
	
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
	
	public Iterable<User> getUsers(){
		String getUsersUrl = props.getApiUrl() + "/user";
		ResponseEntity<Iterable<User>> response = restTemplate.exchange(
			getUsersUrl, 
			HttpMethod.GET, 
			null, 
			new ParameterizedTypeReference<Iterable<User>>() {});
		
		return response.getBody();
	}
	public User createUser(User user) {
		
		String createUserUrl = props.getApiUrl() + "/user"; 
		
		HttpEntity<User> requestEntity = new HttpEntity<User>(user);
		ResponseEntity<User> response = restTemplate.exchange(
				createUserUrl, 
				HttpMethod.POST, 
				requestEntity, 
				User.class);
		
		return response.getBody();
	}
	
	public User updateUser(User user) {
		String updateUserUrl = props.getApiUrl() + "/user/" + user.getId();
		HttpEntity<User> requestEntity = new HttpEntity<User>(user);
		ResponseEntity<User> response = restTemplate.exchange(
				updateUserUrl, 
				HttpMethod.PUT, 
				requestEntity, 
				User.class);
		
		return response.getBody();
	}
	
	public void deleteUser(Integer id) {
		String deleteUserUrl = props.getApiUrl() + "/user/" + id;
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteUserUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		System.out.println(response.getStatusCode().toString());
		
	}

}
