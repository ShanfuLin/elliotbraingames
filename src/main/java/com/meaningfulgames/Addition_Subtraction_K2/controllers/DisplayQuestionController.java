package com.meaningfulgames.Addition_Subtraction_K2.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meaningfulgames.Addition_Subtraction_K2.model.MathQuestion;
import com.meaningfulgames.Addition_Subtraction_K2.model.QuizScore;
import com.meaningfulgames.Addition_Subtraction_K2.service.CreateMathQuestion;

@Controller
public class DisplayQuestionController {
	
	@Autowired
	private CreateMathQuestion createMathQuestion;
	
	@GetMapping(value = { "/", "/MathQuestions"})
	public String DisplayMathQuestions(Model model) {
		List<MathQuestion> tenQuestions = createMathQuestion.createTenRandomQuestions();
		model.addAttribute("tenQuestions", tenQuestions);
		return "gamepage";
	}
	
	@GetMapping(value = {"/CountingDollarsAndCents"})
	public String CountDollarsAndCents(Model model) {
		double[] myDoubleNumbers = createMathQuestion.createTenRandomDoubleNumbers();
		for (double individual :myDoubleNumbers) {
			System.out.println(individual);
		}
		model.addAttribute("tenDoubleNumbers", myDoubleNumbers);
		return "countmoneypage";
	}
	
	@GetMapping(value = {"/MultiplicationOneToTen"})
	public String MultiplicationOneToTen(Model model) {
		List<MathQuestion> tenQuestions = createMathQuestion.createTenRandomMultiplicationQuestions();
		System.out.println("Hello World!");
		System.out.println(tenQuestions.size());
		for (MathQuestion individual: tenQuestions) {
			System.out.println(individual);
		}
		model.addAttribute("tenQuestions", tenQuestions);
		return "simple_multiplication_sweets";
	}
	
}
