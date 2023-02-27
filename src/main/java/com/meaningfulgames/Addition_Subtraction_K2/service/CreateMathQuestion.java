package com.meaningfulgames.Addition_Subtraction_K2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.meaningfulgames.Addition_Subtraction_K2.model.MathQuestion;
import com.meaningfulgames.Addition_Subtraction_K2.model.QuestionType;

@Service
public class CreateMathQuestion {
	
	public List<MathQuestion> createTenRandomQuestions(){
		int counter = 0;
		Random randomNumber = new Random();
		List<MathQuestion> tenQuestions = new ArrayList<MathQuestion>();
		while (counter < 10) {
			int dice = randomNumber.nextInt(0,2);
			if (dice == 0) {
				boolean checkMoreThan100 = true;
				MathQuestion additionQuestion = new MathQuestion();
				while (checkMoreThan100 == true) {
					int firstNumber = randomNumber.nextInt(11, 99);
					int secondNumber = randomNumber.nextInt(11, 99);
					int sumBothNumbers = firstNumber + secondNumber;
					if (sumBothNumbers < 100) {
						additionQuestion.setFirstNumberPair(firstNumber);
						additionQuestion.setSecondNumberPair(secondNumber);
						additionQuestion.setQuestionType(QuestionType.ADDITION);
						additionQuestion.setAnswer(sumBothNumbers);
						tenQuestions.add(additionQuestion);
						checkMoreThan100 = false;
					}
					else {
						checkMoreThan100 = true;
					}
				}
			}
			else {
				boolean checkFirstBiggerThanSecond = true;
				while (checkFirstBiggerThanSecond == true) {
					int firstNumber = randomNumber.nextInt(11, 99);
					int secondNumber = randomNumber.nextInt(11, 99);
					MathQuestion minusQuestion = new MathQuestion();
					if (firstNumber > secondNumber) {
						int minusAnswer = firstNumber - secondNumber;
						minusQuestion.setFirstNumberPair(firstNumber);
						minusQuestion.setSecondNumberPair(secondNumber);
						minusQuestion.setQuestionType(QuestionType.SUBTRACTION);
						minusQuestion.setAnswer(minusAnswer);
						tenQuestions.add(minusQuestion);
						checkFirstBiggerThanSecond = false;
					}
					else {
						checkFirstBiggerThanSecond = true;
					}
					
				}
			}
			counter += 1;
		}
		return tenQuestions;
	}

}
