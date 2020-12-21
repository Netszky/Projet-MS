package ynov.projetms.webClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ynov.projectms.webClient.model.Article;
import ynov.projectms.webClient.repository.ArticleProxy;
import ynov.projectms.webClient.repository.CategoryProxy;
import ynov.projectms.webClient.repository.CommentProxy;
import ynov.projectms.webClient.repository.UserProxy;

@Controller
public class WebClientController {
	
	@Autowired
	private UserProxy userProxy;
	
	@Autowired 
	private CategoryProxy categoryProxy;
	
	@Autowired 
	private ArticleProxy articleProxy;
	
	@Autowired 
	private CommentProxy commentProxy;
	/**
	@GetMapping("/home")
	public String getHomePage(Model model) {
		Iterable<Article> articles = articleProxy.getArticles();
		model.addAttribute("articles", articles);
		return "homePage";
	}**/
	@GetMapping("/home/{id}")
	public String getHomePage(@PathVariable int id, Model model) {
		Article article = articleProxy.getArticle(id);
		model.addAttribute("article", article);
		return "homePage";
	}
	
}
