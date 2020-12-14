package ynov.projetms.article.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetms.article.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
