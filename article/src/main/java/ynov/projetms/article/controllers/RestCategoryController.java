package ynov.projetms.article.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetms.article.model.Category;

import ynov.projetms.article.repositories.CategoryRepository;

@RestController
public class RestCategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public Iterable<Category> getCategories(){
		Iterable<Category> categories = categoryRepository.findAll();
		return categories;
	}
	@GetMapping("/category/{id}")
	public Optional<Category> getCategory(@PathVariable("id")int id){
		Optional<Category> category= categoryRepository.findById(id);
		return category;
	}
	@PostMapping("/category")
	public Category createCategory(@RequestBody Category category) {
		category = categoryRepository.save(category);
		return category;
	}
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
	}
}
