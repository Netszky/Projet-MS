package ynov.projetms.article.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ArticleR getArticle(@PathVariable int id) {
		return articleService.getArticle(id);
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
