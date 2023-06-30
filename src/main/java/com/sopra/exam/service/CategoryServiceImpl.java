package com.sopra.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.exam.entity.Category;
import com.sopra.exam.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category createCategory(Category category) {
		return this.categoryRepo.save(category);
	}

	
	
	
	@Override
	public Category getCategory(Long id) {
		Category orElseThrow = this.categoryRepo.findById(id).orElseThrow(null);
		
		return orElseThrow;
	}

	@Override
	public void deleteCategory(Long id) {
		Category orElseThrow = this.categoryRepo.findById(id).orElseThrow(null);
		this.categoryRepo.delete(orElseThrow);
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> findAll = this.categoryRepo.findAll();
		return findAll;
	}


	@Override
	public Category updateCategory(Category category) {
		return  this.categoryRepo.save(category);
	}

}
