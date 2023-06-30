package com.sopra.exam.service;

import java.util.List;

import com.sopra.exam.entity.Category;

public interface CategoryService {
	
	public Category createCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Category getCategory(Long id);
	
	public void deleteCategory(Long id);
	
	public List<Category> getAllCategory();
	

}
