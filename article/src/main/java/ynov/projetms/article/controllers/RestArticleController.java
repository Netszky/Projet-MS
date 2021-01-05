package ynov.projetms.article.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetms.article.dto.ArticleR;
import ynov.projetms.article.model.Article;
import ynov.projetms.article.repositories.ArticleRepository;
import ynov.projetms.article.service.ArticleService;

@RestController
public class RestArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article")
	public Iterable<ArticleR> getArticles(){
		return articleService.getArticles();
	}
	@GetMapping("/article/{id}")
	public ArticleR getArticle(@PathVariable("id") int id) {
		return articleService.getArticle(id);
	}
	@PostMapping("/article")
	public Article createArticle(@RequestBody Article article) {
		article = articleRepository.save(article);
		return article;
	}
	@PutMapping("/article/{id}")
	public Article updateArticle(@PathVariable("id") int id, @RequestBody Article article) {
		Article currentArticle = articleRepository.findById(id).get();
		String content = article.getContent();
		String title = article.getTitle();
		Integer category = article.getId_category();
		Integer user = article.getId_user();
		if(category != null) {
			currentArticle.setId_category(category);
		}
		if(user != null) {
			currentArticle.setId_user(user);
		}
		if(content != null) {
			currentArticle.setContent(content);
		}
		if(title != null) {
			currentArticle.setTitle(title);
		}
		currentArticle = articleRepository.save(currentArticle);
		return currentArticle;
	}
	@DeleteMapping("/article/{id}")
	public void deleteArticle(@PathVariable("id") int id) {
		articleRepository.deleteById(id);
	}
	@GetMapping("/article/category/{id}")
	public Iterable<ArticleR> getArticleByCategory(@PathVariable("id") int id){
		return articleService.getByCategory(id);
	}
	@DeleteMapping("/article/category/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        articleRepository.deleteAllByCategory(id);
    }
	@DeleteMapping("/article/user/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        articleRepository.deleteAllByUser(id);
    }
}
