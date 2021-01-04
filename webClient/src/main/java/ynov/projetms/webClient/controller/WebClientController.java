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
		Iterable<Category> categories = categoryProxy.getCategories();
		model.addAttribute("categories", categories);
		Iterable<User> users = userProxy.getUsers();
		model.addAttribute("users", users);
		return "homePage";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable int id, Model model) {
		User user = userProxy.getUser(id);
		model.addAttribute("user", user);
		return "user";
	}
	
	@GetMapping("/register")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "formCreateUser";
	}
	
	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		if(user.getId() == null) {
			userProxy.createUser(user);
		}
		else {
			userProxy.updateUser(user);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/category/{id}")
	public String getCategoryArticles(@PathVariable int id, Model model) {
		Category category = categoryProxy.getCategory(id);
		model.addAttribute("category", category);
		Iterable<Article> article = articleProxy.getArticleByCategorie(id);
		model.addAttribute("article", article);
		return "category";
	}
	
	@GetMapping("/category/new")
	public String createCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "formCreateCategory";
	}
	
	@PostMapping("/saveCategory")
	public ModelAndView saveCategory(@ModelAttribute Category category) {
		if(category.getId() == null) {
			categoryProxy.createCategory(category);
		}
		else {
			categoryProxy.updateCategory(category);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/article/{id}")
	public String getArticle(@PathVariable int id, Model model) {
		Article article = articleProxy.getArticle(id);
		model.addAttribute("article", article);
		Iterable<Comment> comments = commentProxy.getCommentByArticle(id);
		model.addAttribute("comments", comments);
		Comment comment = new Comment();
		model.addAttribute("newComment", comment);
		Iterable<User> users = userProxy.getUsers();
		model.addAttribute("users", users);
		return "article";
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
	
	@GetMapping("/article/new")
	public String createPost(Model model) {
		Iterable<Category> categories = categoryProxy.getCategories();
		model.addAttribute("categories", categories);
		Iterable<User> users = userProxy.getUsers();
		model.addAttribute("users", users);
		Article article = new Article();
		model.addAttribute("article", article);
		return "formCreatePost";
	}
	@GetMapping("/category")
	public String getCategoryPage(Model model) {
		Iterable<Category> categories = categoryProxy.getCategories();
		model.addAttribute("categories", categories);
		return "categoryList";
	}
	
	@GetMapping("/user")
	public String getUserPage(Model model) {
		Iterable<User> users = userProxy.getUsers();
		model.addAttribute("users", users);
		return "userList";
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
	
	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable int id) {
		userProxy.deleteUser(id);
		articleProxy.deleteArticleByUser(id);
		return new ModelAndView("redirect:/home");
	}
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		User user = userProxy.getUser(id);
		model.addAttribute("user", user);
		return "formUpdateUser";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public ModelAndView deleteCategory(@PathVariable int id) {
		categoryProxy.deleteCategory(id);
		articleProxy.deleteArticleByCategory(id);
		return new ModelAndView("redirect:/home");
	}
	@GetMapping("/updateCategory/{id}")
	public String updateCategory(@PathVariable int id, Model model) {
		Category category = categoryProxy.getCategory(id);
		model.addAttribute("category", category);
		return "formUpdateCategory";
	}
	
}
