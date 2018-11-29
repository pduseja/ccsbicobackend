package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "UsersDetails")
@JacksonXmlRootElement(localName = "UsersDetails")
@SuppressWarnings("serial")
public class UsersDetails implements Serializable {
	
	@ApiModelProperty(name = "id", required = true, readOnly = true, value = "The UsersDetails iD")
	@JsonProperty("id")
	@JacksonXmlProperty(localName = "id")
	private int id;
		
	@ApiModelProperty(name = "isTempPassword", value = "isTempPassword")
	@JsonProperty("isTempPassword")
	@JacksonXmlProperty(localName = "isTempPassword")
	private char isTempPassword;
	
	@ApiModelProperty(name = "securityQuestionId1", value = "securityQuestionId1")
	@JsonProperty("securityQuestionId1")
	@JacksonXmlProperty(localName = "securityQuestionId1")
	private int securityQuestionId1;
	
	@ApiModelProperty(name = "securityQuestionId2", value = "securityQuestionId2")
	@JsonProperty("securityQuestionId2")
	@JacksonXmlProperty(localName = "securityQuestionId2")
	private int securityQuestionId2;
	
	@ApiModelProperty(name = "SecurityAnswer1", value = "SecurityAnswer1")
	@JsonProperty("SecurityAnswer1")
	@JacksonXmlProperty(localName = "SecurityAnswer1")
	private String SecurityAnswer1;
	
	@ApiModelProperty(name = "SecurityAnswer2", value = "SecurityAnswer2")
	@JsonProperty("SecurityAnswer2")
	@JacksonXmlProperty(localName = "SecurityAnswer2") 
	private String SecurityAnswer2;
	
	@ApiModelProperty(name = "password", value = "password")
	@JsonProperty("password")
	@JacksonXmlProperty(localName = "password") 
	private String password;
	
	@ApiModelProperty(name = "memorableWord", value = "memorableWord")
	@JsonProperty("memorableWord")
	@JacksonXmlProperty(localName = "memorableWord")
	private String memorableWord;
	
	@ApiModelProperty(name = "inserted", value = "inserted")
	@JsonProperty("inserted")
	@JacksonXmlProperty(localName = "inserted")
	private Date inserted;
	
	@ApiModelProperty(name = "modDate", value = "modDate")
	@JsonProperty("modDate")
	@JacksonXmlProperty(localName = "modDate")
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
