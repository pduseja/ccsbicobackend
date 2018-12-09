package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "SecurityQuestions")
@JacksonXmlRootElement(localName = "SecurityQuestions")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class SecurityQuestions implements Serializable {
	
	@ApiModelProperty(name = "securityQuestionId", required = true, readOnly = true, value = "The security question ID")
	@JsonProperty("securityQuestionId")
	@JacksonXmlProperty(localName = "securityQuestionId")
	private int securityQuestionId;
	
	@ApiModelProperty(name = "hintQuestion", value = "hintQuestion")
	@JsonProperty("hintQuestion")
	@JacksonXmlProperty(localName = "hintQuestion")
	private String hintQuestion;
	
	@ApiModelProperty(name = "createdBy", value = "createdBy")
	@JsonProperty("createdBy")
	@JacksonXmlProperty(localName = "createdBy")
	private String createdBy;
	
	@ApiModelProperty(name = "creationDate", value = "creationDate")
	@JsonProperty("creationDate")
	@JacksonXmlProperty(localName = "creationDate")
	private Date creationDate;
	
	@ApiModelProperty(name = "updatedBy", value = "updatedBy")
	@JsonProperty("updatedBy")
	@JacksonXmlProperty(localName = "updatedBy")
	private String updatedBy;
	
	@ApiModelProperty(name = "updatedDate", value = "updatedDate")
	@JsonProperty("updatedDate")
	@JacksonXmlProperty(localName = "updatedDate")
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
