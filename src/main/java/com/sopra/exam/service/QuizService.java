package com.sopra.exam.service;

import java.util.List;

import com.sopra.exam.entity.Category;
import com.sopra.exam.entity.Quiz;

public interface QuizService {
	
	Quiz createQuiz(Quiz quiz);
	
	Quiz updateQuiz( Quiz quiz);
	
	List<Quiz> getAllQuiz();
	
	Quiz getQuiz(Long id);
	
	void deleteQuiz(Long id);
	
	List<Quiz> getAllQuizByCategoryId(Category category);

	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
