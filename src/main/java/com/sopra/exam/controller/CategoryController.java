package com.sopra.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.exam.entity.Category;
import com.sopra.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public Category addQuiz(@RequestBody Category category) {
		return this.categoryService.createCategory(category);
	}
	
	@PutMapping("/")
	public Category updateQuiz(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
	@GetMapping("/")
	public List<Category> getAllCategory(){
		return this.categoryService.getAllCategory();
	}
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) {
		return this.categoryService.getCategory(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		this.categoryService.deleteCategory(id);
	}
	

}
