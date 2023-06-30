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
import com.sopra.exam.entity.Quiz;
import com.sopra.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return this.quizService.createQuiz(quiz);
	}
	
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizService.updateQuiz(quiz);
	}
	@GetMapping("/")
	public List<Quiz> getAllQuiz(){
	return this.quizService.getAllQuiz();
	}
	
	@GetMapping("/{id}")
	public Quiz getQuiz(@PathVariable Long id) {
		return this.quizService.getQuiz(id);
	}
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable Long id) {
		this.quizService.deleteQuiz(id);
	}
	//get allquiz by categoryId
	@GetMapping("/category/{id}")
	public List<Quiz> getAllQuizByCategoryId(@PathVariable Long id){
		Category category= new Category();
		category.setCid(id);
		return this.quizService.getAllQuizByCategoryId(category);
	}
	//get actice quiz
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizzes();
	}
	@GetMapping("/category/active/{id}")
	public List<Quiz> getActiveQuizzesByCategory(@PathVariable Long id){
		Category category=new Category();
		category.setCid(id);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}

}
