package ynov.projetms.webClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/createPost")
	public String createPost(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "formCreatePost";
	}
	
	@PostMapping("/savePost")
		public ModelAndView saveArticle(@ModelAttribute Article article) {
			if(article.getId() == null) {
				articleProxy.createArticle(article);
			}
			else {
				articleProxy.updateArticle(article);
			}
			return new ModelAndView("redirect:/");
	}
	@GetMapping("/deleteArticle/{id}")
	public ModelAndView deleteArticle(@PathVariable int id) {
		articleProxy.deleteArticle(id);
		return new ModelAndView("redirect:/");
	}
	@GetMapping("/updateArticle/{id}")
	public String updateArticle(@PathVariable int id, Model model) {
		Article article = articleProxy.getArticle(id);
		model.addAttribute("article", article);
		return "formUpdateArticle";
	}
}
