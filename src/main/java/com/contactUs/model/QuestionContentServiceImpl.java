package com.contactUs.model;

import java.util.List;

import javax.naming.NamingException;

public class QuestionContentServiceImpl implements QuestionContentService {
	
	private QuestionContentDao dao;
	
	public QuestionContentServiceImpl() throws NamingException{
		dao = new QuestionContentDaoImpl();
	}

	@Override
	public Boolean submitQuestion(QuestionContentVO questionContent) {
		final Integer questionType = questionContent.getQuestionTypeID();
		final String questionContentString = questionContent.getQuestionContent();

		if (questionType == null) {
			// final String pickType = "請選擇問題類型";
			return false;
		}

		if (questionContentString.isEmpty()) {
			// final String inputQ = "請輸入問題內容";
			return false;
		}
		
		final Integer id = dao.insert(questionContent);
		if (id == null) {
			return false;
		}
		
		return true;
	}

	
	@Override
	public List<QuestionContentVO> findAllQs() {	
		return dao.selectAll();
	}

}// class
