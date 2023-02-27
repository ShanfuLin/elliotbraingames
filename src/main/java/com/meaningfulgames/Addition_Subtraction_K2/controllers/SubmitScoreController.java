package com.meaningfulgames.Addition_Subtraction_K2.controllers;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meaningfulgames.Addition_Subtraction_K2.model.QuizScore;
import com.meaningfulgames.Addition_Subtraction_K2.service.QuizScoreService;

@RestController
@RequestMapping("/submitscore")
public class SubmitScoreController {
	
	@Autowired
	private QuizScoreService quizscoreservice;
	
	@RequestMapping(value ={""}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<QuizScore> submitScore(@RequestBody QuizScore quizscore) {
		LocalDateTime datetimenow = LocalDateTime.now();
		quizscore.setDatetime(datetimenow);
        var headers = new HttpHeaders();
        headers.add("Responded", "MyController");
        QuizScore savedquizscore = quizscoreservice.saveQuizScore(quizscore);
        return ResponseEntity.accepted().headers(headers).body(savedquizscore);
	}
}
