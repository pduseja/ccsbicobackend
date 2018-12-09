package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@SuppressWarnings("serial")
@Entity(name ="securityquestions")
public class SecurityQuestions implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "securityquestionid")
	private int securityQuestionId;
	
	@Column(name = "hintquestion")
	private String hintQuestion;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "creationDate")
	private Date creationDate;
	
	@Column(name = "updatedby")
	private String updatedBy;
	
	@Column(name = "updatedDate")
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

	@PrePersist
	private void prePersist() {
		Date rightNow = new Date(Calendar.getInstance().getTime().getTime());
		this.creationDate = Optional.ofNullable(this.getCreationDate()).orElse(rightNow);
		this.updatedDate = Optional.ofNullable(this.getUpdatedDate()).orElse(rightNow);
	}
}
