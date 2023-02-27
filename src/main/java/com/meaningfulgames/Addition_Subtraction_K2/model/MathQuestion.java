package com.meaningfulgames.Addition_Subtraction_K2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MathQuestion {
	
	@Id
	private Double id;
	
	private int firstNumberPair;
	
	private int secondNumberPair;
	
	private QuestionType questionType;
	
	private int answer;
	
	private int setAnswer() {
		if(this.questionType.toString() == "Addition") {
			this.answer = firstNumberPair + secondNumberPair;
		}
		else if(this.questionType.toString() == "Subtraction") {
			this.answer = firstNumberPair - secondNumberPair;
		}
		return answer;
	}
}
