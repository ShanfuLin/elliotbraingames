package com.meaningfulgames.Addition_Subtraction_K2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meaningfulgames.Addition_Subtraction_K2.model.QuizScore;
import com.meaningfulgames.Addition_Subtraction_K2.repository.QuizScoreRepository;

@Service
public class QuizScoreServiceImpl implements QuizScoreService {
	
	@Autowired
	private QuizScoreRepository quizscorerepo;
	
	@Override
	public QuizScore saveQuizScore(QuizScore newQuizScore) {
		QuizScore savedQuizScore = quizscorerepo.saveAndFlush(newQuizScore);
		return savedQuizScore;
	}
}
