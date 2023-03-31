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
	
	@SuppressWarnings("unused")
	private int setAnswer() {
		if(this.questionType.toString() == "Addition") {
			this.answer = firstNumberPair + secondNumberPair;
		}
		else if(this.questionType.toString() == "Subtraction") {
			this.answer = firstNumberPair - secondNumberPair;
		}
		else if(this.questionType.toString() == "Multiplication") {
			this.answer = firstNumberPair * secondNumberPair;
		}		
		return answer;
	}
	
	@Override
	public String toString() {
		String toPrint = "";
		if(this.questionType.toString() == "MULTIPLICATION") {
			toPrint = Integer.toString(this.firstNumberPair).concat(" x ").concat(Integer.toString(this.secondNumberPair)).concat(" = ").concat(Integer.toString(this.answer));
		} else if (this.questionType.toString() == "ADDITION") {
			toPrint = Integer.toString(this.firstNumberPair).concat(" + ").concat(Integer.toString(this.secondNumberPair)).concat(" = ").concat(Integer.toString(this.answer));
		}
		else if (this.questionType.toString() == "SUBTRACTION") {
			toPrint = Integer.toString(this.firstNumberPair).concat(" - ").concat(Integer.toString(this.secondNumberPair)).concat(" = ").concat(Integer.toString(this.answer));
		}
		return toPrint;
	}
}
