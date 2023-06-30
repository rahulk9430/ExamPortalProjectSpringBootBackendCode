package com.sopra.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.exam.entity.Category;
import com.sopra.exam.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {
	
	List<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
