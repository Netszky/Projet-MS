package ynov.projetms.article.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ynov.projetms.article.model.Article;
import ynov.projetms.article.repositories.CommentProxy;
import ynov.projetms.article.repositories.UserProxy;

@Component
public class ArticleTransformer {
	@Autowired
	private UserProxy userProxy;
	@Autowired
	CommentProxy commentProxy;
	
	public ArticleR transform(Article a) {
		ArticleR articleR = new ArticleR();
		
		articleR.setId(a.getId());
		articleR.setContent(a.getContent());
		articleR.setDate(a.getDate());
		articleR.setId_category(a.getId_category());
		//Comment comment = commentProxy.getComment(a.getComment());
		//articleR.setComment(comment);
		User user = userProxy.getUser(a.getId());
		articleR.setUser(user);
		
		return articleR;
	}
}
