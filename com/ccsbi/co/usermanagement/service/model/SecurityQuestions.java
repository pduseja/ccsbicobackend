package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SecurityQuestions implements Serializable {
	
	private int securityQuestionId;
	
	private String hintQuestion;
	
	private String createdBy;
	
	private Date creationDate;
	
	private String updatedBy;
	
	private Date updatedDate;

	/**
	 * @return the securityQuestionId
	 */
	public int getSecurityQuestionId() {
		return securityQuestionId;
	}

	/**
	 * @param securityQuestionId the securityQuestionId to set
	 */
	public void setSecurityQuestionId(int securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	/**
	 * @return the hintQuestion
	 */
	public String getHintQuestion() {
		return hintQuestion;
	}

	/**
	 * @param hintQuestion the hintQuestion to set
	 */
	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
