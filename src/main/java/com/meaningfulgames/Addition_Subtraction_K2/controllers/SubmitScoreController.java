package com.meaningfulgames.Addition_Subtraction_K2.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meaningfulgames.Addition_Subtraction_K2.model.QuizScore;
import com.meaningfulgames.Addition_Subtraction_K2.model.WrongAnswerRecord;
import com.meaningfulgames.Addition_Subtraction_K2.service.QuizScoreService;
import com.meaningfulgames.Addition_Subtraction_K2.service.WrongAnswerRecordService;

@RestController
@RequestMapping("/submitscore")
public class SubmitScoreController {
	
	@Autowired
	private QuizScoreService quizscoreservice;
	
	@Autowired
	private WrongAnswerRecordService wronganswerrecordservice;
	
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
	
	@RequestMapping(value ={"/wronganswersrecord"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> submitScore(@RequestBody Map<String, Object> payload) {
		List<String> myarray = (List<String>) payload.get("questions");
		for (String individualitem : myarray) {
			WrongAnswerRecord wronganswer = new WrongAnswerRecord();
			wronganswer.setQuestionAndWrongAnswer(individualitem);
			wronganswer.setSubmitteddatetime(LocalDateTime.now());
			wronganswerrecordservice.savewronganswerrecord(wronganswer);
		}
		return ResponseEntity.ok("Wrong answers recorded!");
	}
}
