package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
public class UsersDetails implements Serializable {
	
	private int id;

	private char isTempPassword;

	private int securityQuestionId1;

	private int securityQuestionId2;

	private String SecurityAnswer1;

	private String SecurityAnswer2;

	private String password;

	private String memorableWord;

	private Date inserted;
	
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
	 * @return the isTempPassword
	 */
	public char getIsTempPassword() {
		return isTempPassword;
	}

	/**
	 * @param isTempPassword the isTempPassword to set
	 */
	public void setIsTempPassword(char isTempPassword) {
		this.isTempPassword = isTempPassword;
	}

	/**
	 * @return the securityQuestionId1
	 */
	public int getSecurityQuestionId1() {
		return securityQuestionId1;
	}

	/**
	 * @param securityQuestionId1 the securityQuestionId1 to set
	 */
	public void setSecurityQuestionId1(int securityQuestionId1) {
		this.securityQuestionId1 = securityQuestionId1;
	}

	/**
	 * @return the securityQuestionId2
	 */
	public int getSecurityQuestionId2() {
		return securityQuestionId2;
	}

	/**
	 * @param securityQuestionId2 the securityQuestionId2 to set
	 */
	public void setSecurityQuestionId2(int securityQuestionId2) {
		this.securityQuestionId2 = securityQuestionId2;
	}

	/**
	 * @return the securityAnswer1
	 */
	public String getSecurityAnswer1() {
		return SecurityAnswer1;
	}

	/**
	 * @param securityAnswer1 the securityAnswer1 to set
	 */
	public void setSecurityAnswer1(String securityAnswer1) {
		SecurityAnswer1 = securityAnswer1;
	}

	/**
	 * @return the securityAnswer2
	 */
	public String getSecurityAnswer2() {
		return SecurityAnswer2;
	}

	/**
	 * @param securityAnswer2 the securityAnswer2 to set
	 */
	public void setSecurityAnswer2(String securityAnswer2) {
		SecurityAnswer2 = securityAnswer2;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the memorableWord
	 */
	public String getMemorableWord() {
		return memorableWord;
	}

	/**
	 * @param memorableWord the memorableWord to set
	 */
	public void setMemorableWord(String memorableWord) {
		this.memorableWord = memorableWord;
	}

	/**
	 * @return the inserted
	 */
	public Date getInserted() {
		return inserted;
	}

	/**
	 * @param inserted the inserted to set
	 */
	public void setInserted(Date inserted) {
		this.inserted = inserted;
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
}
