package com.meaningfulgames.Addition_Subtraction_K2.service;

import org.springframework.stereotype.Service;

import com.meaningfulgames.Addition_Subtraction_K2.model.WrongAnswerRecord;

@Service
public interface WrongAnswerRecordService {
	
	WrongAnswerRecord savewronganswerrecord(WrongAnswerRecord record);
}
