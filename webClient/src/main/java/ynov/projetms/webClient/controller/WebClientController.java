package ynov.projetms.webClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}
