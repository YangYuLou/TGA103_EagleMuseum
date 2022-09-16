package com.contactUs.model;

import java.util.List;

public interface QuestionContentDao {

	Integer insert(QuestionContentVO questionContent);
	List<QuestionContentVO> selectAll();

}