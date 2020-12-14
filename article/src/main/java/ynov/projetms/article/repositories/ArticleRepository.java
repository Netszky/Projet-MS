package ynov.projetms.article.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ynov.projetms.article.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
