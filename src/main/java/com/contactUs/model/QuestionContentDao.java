package com.contactUs.model;

import java.util.List;

public interface QuestionContentDao {
	
	
	void insertAns(QuestionContentVO questionContent);
	Integer insert(QuestionContentVO questionContent);
	List<QuestionContentVO> selectAll();
	List<QuestionContentVO> findByMemberId(Integer memberId);

}