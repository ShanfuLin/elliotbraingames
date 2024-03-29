package com.meaningfulgames.Addition_Subtraction_K2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum QuestionType {
	
	ADDITION("Addition"),
	MULTIPLICATION("Multiplication"),
	SUBTRACTION("Subtraction");
	
	@Getter
	public String value;
}
