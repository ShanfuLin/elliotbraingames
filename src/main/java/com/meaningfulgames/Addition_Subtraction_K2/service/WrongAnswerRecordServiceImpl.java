package com.meaningfulgames.Addition_Subtraction_K2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meaningfulgames.Addition_Subtraction_K2.model.WrongAnswerRecord;
import com.meaningfulgames.Addition_Subtraction_K2.repository.WrongAnswerRepository;

@Service
public class WrongAnswerRecordServiceImpl implements WrongAnswerRecordService{
	
	@Autowired
	private WrongAnswerRepository wronganswerrepository; 
	
	public WrongAnswerRecord savewronganswerrecord(WrongAnswerRecord record) {
		return wronganswerrepository.saveAndFlush(record);
	}
}
