package com.contactUs.model;

import java.sql.Timestamp;
import java.util.List;

public interface QuestionContentService {
	
	
	Boolean submitAnswer(QuestionContentVO questionContent); 
	Boolean submitQuestion(QuestionContentVO questionContent); 
	List<QuestionContentVO> findAllQs();
	List<QuestionContentVO> getByMemberId(Integer memberId);
	List<QuestionContentVO> getByDate(String lastUpdateDate1, String lastUpdateDate2);
}
