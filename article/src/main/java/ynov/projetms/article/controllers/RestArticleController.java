package ynov.projetms.article.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetms.article.model.Article;
import ynov.projetms.article.repositories.ArticleRepository;

@RestController
public class RestArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/article")
	public Iterable<Article> getArticles(){
		Iterable<Article> articles = articleRepository.findAll();
		return articles;
	}
	@GetMapping("/article/{id}")
	public Optional<Article> getArticle(@PathVariable("id")int id){
		Optional<Article> article = articleRepository.findById(id);
		return article;
	}
	@PostMapping("/article")
	public Article createArticle(@RequestBody Article article) {
		article = articleRepository.save(article);
		return article;
	}
	@DeleteMapping("/article/{id}")
	public void deleteArticle(@PathVariable("id") int id) {
		articleRepository.deleteById(id);
	}
}
