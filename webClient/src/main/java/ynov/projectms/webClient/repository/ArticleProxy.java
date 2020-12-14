package ynov.projectms.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;

import ynov.projectms.webClient.CustomProperties;
import ynov.projectms.webClient.model.Article;

public class ArticleProxy extends GenericProxy {
	
	@Autowired
	private CustomProperties props;
	
	public Article getArticle(int id) {
		String getArticleUrl = props.getApiUrl() +"/article/" + id;
		ResponseEntity<Article> response = restTemplate.exchange(
				getArticleUrl, 
				HttpMethod.GET, 
				null, 
				Article.class);
			return response.getBody();
	}
	
	public Iterable<Article> getArticles(){
		String getArticleUrl = props.getApiUrl() + "/article";
		ResponseEntity<Iterable<Article>> response = restTemplate.exchange(
				getArticleUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<Article>>() {});
		return response.getBody();
	}
	
	public Article createArticle(Article article) {
		String createArticleUrl = props.getApiUrl() + "/article";
		
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(article);
		ResponseEntity<Article> response = restTemplate.exchange(
				createArticleUrl, 
				HttpMethod.POST, 
				requestEntity, 
				Article.class);
		
		return response.getBody();
	}
	public Article updateArticle(Article article) {
		String updateArticleUrl = props.getApiUrl() + "/article/" + article.getId();
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(article);
		ResponseEntity<Article> response = restTemplate.exchange(
				updateArticleUrl, 
				HttpMethod.PUT, 
				requestEntity, 
				Article.class);
		
		return response.getBody();
	}
	public void deleteArticle(Integer id) {
		String deleteArticleUrl = props.getApiUrl() + "/article/" + id;
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteArticleUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		System.out.println(response.getStatusCode().toString());
		
	}
}

