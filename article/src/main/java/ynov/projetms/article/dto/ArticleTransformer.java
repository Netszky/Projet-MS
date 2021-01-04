package ynov.projetms.article.dto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ynov.projetms.article.model.Article;
import ynov.projetms.article.model.Comment;
import ynov.projetms.article.model.User;
import ynov.projetms.article.repositories.CommentProxy;
import ynov.projetms.article.repositories.UserProxy;

@Component
public class ArticleTransformer {
	@Autowired
	private UserProxy userProxy;
	@Autowired
	private CommentProxy commentProxy;
	
	public ArticleR transform(Article a) {
		ArticleR articleR = new ArticleR();
		
		articleR.setId(a.getId());
		articleR.setContent(a.getContent());
		articleR.setDate(a.getDate());
		articleR.setId_category(a.getId_category());
		articleR.setTitle(a.getTitle());
		Collection<Comment> comment  = (Collection<Comment>) commentProxy.getComment(a.getId());
		articleR.setComments(comment);
		User user = userProxy.getUser(a.getId_user());
		articleR.setUser(user);
		
		return articleR;
	}
}
