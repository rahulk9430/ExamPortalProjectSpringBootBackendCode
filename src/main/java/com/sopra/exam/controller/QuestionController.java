package com.sopra.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.sopra.exam.entity.Question;
import com.sopra.exam.entity.Quiz;
import com.sopra.exam.service.QuestionService;
import com.sopra.exam.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private  QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public Question addQuestion( @RequestBody  Question question) {
		return this.questionService.createQuestion(question);
	}
	
	@PutMapping("/")
	public Question updateQuestion(@RequestBody  Question question) {
		return this.questionService.updateQuestion(question);
	}
	
	@GetMapping("/")
	public List<Question> getAllQuestion(){
		return this.questionService.getAllQuestion();
	}
	
	@GetMapping("/{id}")
	public Question getQuestion(@PathVariable Long id) {
		return this.questionService.getQuestion(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable  Long id) {
		this.questionService.deleteQuestion(id);
	}
	//get all question of any quizId
	@GetMapping("/quiz/{id}")
	public List<Question> getQuestionByQuiz(@PathVariable  Long id){
		
//		Quiz quiz=new Quiz();
//		quiz.setQid(id);
//		return this.questionService.getQuestionByQuiz(quiz);
		
		Quiz quiz = this.quizService.getQuiz(id);
		Set<Question> questions = quiz.getQuestions();
		List list=new ArrayList<>(questions);
		
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
			
		}
		Collections.shuffle(list);
		return list;
		
	}

	//get all question of any quizId
		@GetMapping("/quiz/all/{id}")
		public List<Question> getQuestionByQuizAdmin(@PathVariable  Long id){
			
			Quiz quiz=new Quiz();
			quiz.setQid(id);
			return this.questionService.getQuestionByQuiz(quiz);
			
			
			
		}
}
