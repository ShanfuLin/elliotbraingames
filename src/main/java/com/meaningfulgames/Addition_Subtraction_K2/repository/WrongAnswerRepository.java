package com.meaningfulgames.Addition_Subtraction_K2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meaningfulgames.Addition_Subtraction_K2.model.WrongAnswerRecord;

@Repository
public interface WrongAnswerRepository extends JpaRepository<WrongAnswerRecord, Long> {

}
