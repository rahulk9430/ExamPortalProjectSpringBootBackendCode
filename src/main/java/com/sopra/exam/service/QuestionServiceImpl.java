package com.sopra.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.exam.entity.Question;
import com.sopra.exam.entity.Quiz;
import com.sopra.exam.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private  QuestionRepo questionRepo;
	
	@Override
	public Question createQuestion(Question question) {
		Question save = this.questionRepo.save(question);
		return save;
	}

	
	@Override
	public Question getQuestion(Long id) {
		Question findQuestion = this.questionRepo.findById(id).orElseThrow(null);
		return findQuestion;
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> findAll = this.questionRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteQuestion(Long id) {
		Question findQuestion = this.questionRepo.findById(id).orElseThrow(null);

		this.questionRepo.delete(findQuestion);
	}


	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepo.save(question);
	}


	@Override
	public List<Question> getQuestionByQuiz(Quiz quiz) {
		return this.questionRepo.findByQuiz(quiz);
	}

}
