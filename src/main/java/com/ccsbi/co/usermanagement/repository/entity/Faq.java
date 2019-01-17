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
@Entity(name = "faq")
public class Faq implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;

	@Column(name = "status")
	private String status;

	@Column(name = "sysdate")
	private Date sysDate;

	@Column(name = "moddate")
	private Date modDate;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param active the active to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sysDate
	 */
	public Date getSysDate() {
		return sysDate;
	}

	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	/**
	 * @return the modDate
	 */
	public Date getModDate() {
		return modDate;
	}

	/**
	 * @param modDate the modDate to set
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	@PrePersist
	private void prePersist() {
		Date rightNow = new Date(Calendar.getInstance().getTime().getTime());
		this.modDate = Optional.ofNullable(this.modDate).orElse(rightNow);
	}
}
