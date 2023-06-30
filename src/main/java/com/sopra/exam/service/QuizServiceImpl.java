package com.sopra.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.exam.entity.Category;
import com.sopra.exam.entity.Quiz;
import com.sopra.exam.repo.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;

	@Override
	public Quiz createQuiz(Quiz quiz) {
		return this.quizRepo.save(quiz);
	}

	

	@Override
	public List<Quiz> getAllQuiz() {
		return this.quizRepo.findAll();
	}

	@Override
	public Quiz getQuiz(Long id) {
		Quiz orElseThrow = this.quizRepo.findById(id).orElseThrow(null);
		return orElseThrow;
	}

	@Override
	public void deleteQuiz(Long id) {
		Quiz orElseThrow = this.quizRepo.findById(id).orElseThrow(null);
		Quiz quiz=new Quiz();
		quiz.setQid(id);
		this.quizRepo.delete(quiz);
	}
	



	@Override
	public Quiz updateQuiz( Quiz quiz) {
		//Quiz orElseThrow = this.quizRepo.findById(qid).orElseThrow(null);
		
		
	return this.quizRepo.save(quiz);
		
	}



	@Override
	public List<Quiz> getAllQuizByCategoryId(Category category) {
		return	this.quizRepo.findByCategory(category);
		
	}


	//get active quizzes
	@Override
	public List<Quiz> getActiveQuizzes() {
		return this.quizRepo.findByActive(true);
	}


	//get active quizzes by category
	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		return this.quizRepo.findByCategoryAndActive(c, true);
	}
	
	



	

}
