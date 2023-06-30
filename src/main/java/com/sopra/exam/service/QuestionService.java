package com.sopra.exam.service;

import java.util.List;

import com.sopra.exam.entity.Question;
import com.sopra.exam.entity.Quiz;

public interface QuestionService {
	
	Question createQuestion(Question question);
	
	Question updateQuestion(Question question);
	
	Question getQuestion(Long id);
	
	List<Question> getAllQuestion();
	
	void deleteQuestion(Long id);
	
	List<Question> getQuestionByQuiz(Quiz quiz);

}
