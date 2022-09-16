package com.contactUs.model;

import java.sql.Date;

public class QuestionContentVO {

	private Integer questionContentID;
	private Integer memberId;
	private Integer questionTypeID;
	private String questionContent;
	private String answerContent;
	private Boolean answered;
	private Date lastUpdateTime;

	public QuestionContentVO() {
	}

	public QuestionContentVO(Integer questionContentID, Integer memberId, Integer questionTypeID,
			String questionContent, String answerContent, Boolean answered, Date lastUpdateTime) {
		this.questionContentID = questionContentID;
		this.memberId = memberId;
		this.questionTypeID = questionTypeID;
		this.questionContent = questionContent;
		this.answerContent = answerContent;
		this.answered = answered;
		this.lastUpdateTime= lastUpdateTime;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getQuestionTypeID() {
		return questionTypeID;
	}

	public void setQuestionTypeID(Integer questionTypeID) {
		this.questionTypeID = questionTypeID;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Boolean getAnswered() {
		return answered;
	}

	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getQuestionContentID() {
		return questionContentID;
	}

	public void setQuestionContentID(Integer questionContentID) {
		this.questionContentID = questionContentID;
	}

}
