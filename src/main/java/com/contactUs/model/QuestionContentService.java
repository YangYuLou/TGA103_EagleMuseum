package com.contactUs.model;

import java.util.List;

public interface QuestionContentService {
	
	List<QuestionContentVO> getByMemberId(Integer memberId);
	Boolean submitAnswer(QuestionContentVO questionContent); 
	Boolean submitQuestion(QuestionContentVO questionContent); 
	List<QuestionContentVO> findAllQs();

}
