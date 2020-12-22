package ynov.projetms.webClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ynov.projetms.webClient.model.Article;
import ynov.projetms.webClient.model.Category;
import ynov.projetms.webClient.model.Comment;
import ynov.projetms.webClient.model.User;
import ynov.projetms.webClient.repository.ArticleProxy;
import ynov.projetms.webClient.repository.CategoryProxy;
import ynov.projetms.webClient.repository.CommentProxy;
import ynov.projetms.webClient.repository.UserProxy;

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
	
	@GetMapping("/home")
	public String getHomePage(Model model) {
		Iterable<Article> articles = articleProxy.getArticles();
		model.addAttribute("articles", articles);
		return "homePage";
	}
	
	@GetMapping("/article/{id}")
	public String getHomePage(@PathVariable int id, Model model) {
		Article article = articleProxy.getArticle(id);
		model.addAttribute("article", article);
		return "articlePage";
	}
	
	@GetMapping("/createPost")
	public String createPost(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "formCreatePost";
	}
	@GetMapping("/category")
	public String getCategoryPage(Model model) {
		Iterable<Category> categories = categoryProxy.getCategories();
		model.addAttribute("categories", categories);
		return "categoryPage";
	}
	@GetMapping("/category/{id}")
	public String getArticleByCategory(@PathVariable int id, Model model) {
		Iterable<Article> articles = articleProxy.getArticleByCategorie(id);
		model.addAttribute("articles", articles);
		return "articleCategory";
	}
	
	@PostMapping("/savePost")
		public ModelAndView saveArticle(@ModelAttribute Article article) {
			if(article.getId() == null) {
				articleProxy.createArticle(article);
			}
			else {
				articleProxy.updateArticle(article);
			}
			return new ModelAndView("redirect:/home");
	}
	@GetMapping("/deleteArticle/{id}")
	public ModelAndView deleteArticle(@PathVariable int id) {
		articleProxy.deleteArticle(id);
		return new ModelAndView("redirect:/home");
	}
	@GetMapping("/updateArticle/{id}")
	public String updateArticle(@PathVariable int id, Model model) {
		Article article = articleProxy.getArticle(id);
		model.addAttribute("article", article);
		return "formUpdateArticle";
	}
	@GetMapping("/addComment/{id}")
	public String createComment(Model model) {
		Comment comment = new Comment();
		model.addAttribute("comment", comment);
		return "formComment";
	}
	@PostMapping("/saveComment")
	public ModelAndView saveComment(@ModelAttribute Comment comment) {
		if(comment.getId() == null) {
			commentProxy.createComment(comment);
		}
		else {
			commentProxy.updateComment(comment);
		}
		return new ModelAndView("redirect:/home");
	
	}
	@GetMapping("/register")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "formUser";
	}
	@PostMapping("/saveUser")
		public ModelAndView saveuser(@ModelAttribute User user) {
			if(user.getId() == null) {
				userProxy.createUser(user);
			}
			else {
				userProxy.updateUser(user);
			}
			return new ModelAndView("redirect:/home");
		}
	}
