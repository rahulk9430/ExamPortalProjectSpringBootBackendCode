package com.sopra.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.exam.entity.Question;
import com.sopra.exam.entity.Quiz;

public interface QuestionRepo extends JpaRepository<Question,Long > {

	List<Question> findByQuiz(Quiz quiz);

}
