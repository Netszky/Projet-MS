package ynov.projetms.article.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetms.article.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

	public default Iterable<Article> findaAllByCategoryId(int id){
		Iterable<Article> allArticles = this.findAll();
		List<Article> articleCategory = new ArrayList<Article>();
		for (Article a: allArticles) {
			if(a.getId_category().equals(id)) {
				articleCategory.add(a);
			}
		}
		return articleCategory;
	}
	
}
