package com.meaningfulgames.Addition_Subtraction_K2.service;

import org.springframework.stereotype.Service;

import com.meaningfulgames.Addition_Subtraction_K2.model.QuizScore;

@Service
public interface QuizScoreService {

	QuizScore saveQuizScore(QuizScore newQuizScore);
}
