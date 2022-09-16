package com.contactUs.model;

import java.util.List;

public interface QuestionContentService {
	
	Boolean submitQuestion(QuestionContentVO questionContent); 
	
	List<QuestionContentVO> findAllQs();

}
