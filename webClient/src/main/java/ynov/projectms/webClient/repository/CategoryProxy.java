package ynov.projectms.webClient.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import ynov.projectms.webClient.CustomProperties;
import ynov.projectms.webClient.model.Category;



public class CategoryProxy extends GenericProxy {
	
	@Autowired
	private CustomProperties props;
	
	public Category getCategory(int id) {
		String getCategoryUrl = props.getApiUrl() + "/category/" + id;
		ResponseEntity<Category> response = restTemplate.exchange(
				getCategoryUrl, 
				HttpMethod.GET, 
				null, 
				Category.class);
			return response.getBody();
	}
	public Iterable<Category> getCategories(){
		String getCategoryUrl = props.getApiUrl() + "/category";
		ResponseEntity<Iterable<Category>> response = restTemplate.exchange(
				getCategoryUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<Category>>() {});
		return response.getBody();
	}
	public Category createCategory(Category category) {
		String createCategoryUrl = props.getApiUrl() + "/category";
		
		HttpEntity<Category> requestEntity = new HttpEntity<Category>(category);
		ResponseEntity<Category> response = restTemplate.exchange(
				createCategoryUrl, 
				HttpMethod.POST, 
				requestEntity, 
				Category.class);
		
		return response.getBody();
	}
	public Category updateCategory(Category category) {
		String updateCategoryUrl = props.getApiUrl() + "/category/" + category.getId();
		HttpEntity<Category> requestEntity = new HttpEntity<Category>(category);
		ResponseEntity<Category> response = restTemplate.exchange(
				updateCategoryUrl, 
				HttpMethod.PUT, 
				requestEntity, 
				Category.class);
		
		return response.getBody();
	}
	public void deleteCategory(Integer id) {
		String deleteCategoryUrl = props.getApiUrl() + "/category/" + id;
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteCategoryUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		System.out.println(response.getStatusCode().toString());
		
	}
	
}
