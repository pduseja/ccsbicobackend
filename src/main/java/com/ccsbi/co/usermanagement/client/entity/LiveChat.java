package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "LiveChat")
@JacksonXmlRootElement(localName = "LiveChat")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class LiveChat implements Serializable {

	@ApiModelProperty(name = "liveChatId", required = true, readOnly = true, value = "Chat Id")
	@JsonProperty("liveChatId")
	@JacksonXmlProperty(localName = "liveChatId")
	private int liveChatId;
	
	@ApiModelProperty(name = "firstName", value = "firstName")
	@JsonProperty("firstName")
	@JacksonXmlProperty(localName = "firstName")
	private  String firstName;
	
	@ApiModelProperty(name = "lastName", value = "lastName")
	@JsonProperty("lastName")
	@JacksonXmlProperty(localName = "lastName")
	private String lastName;
	
	@ApiModelProperty(name = "mobile", value = "mobile")
	@JsonProperty("mobile")
	@JacksonXmlProperty(localName = "mobile")
	private int mobile;
	
	@ApiModelProperty(name = "email", value = "email")
	@JsonProperty("email")
	@JacksonXmlProperty(localName = "email")
	private String email;
	
	@ApiModelProperty(name = "serviceRef", value = "serviceRef")
	@JsonProperty("serviceRef")
	@JacksonXmlProperty(localName = "serviceRef")
	private String serviceRef;
	
	@ApiModelProperty(name = "department", value = "department")
	@JsonProperty("department")
	@JacksonXmlProperty(localName = "department")
	private String department;
	
	@ApiModelProperty(name = "priority", value = "priority")
	@JsonProperty("priority")
	@JacksonXmlProperty(localName = "priority")
	private int priority;
	
	@ApiModelProperty(name = "queue", value = "queue")
	@JsonProperty("queue")
	@JacksonXmlProperty(localName = "queue")
	private int queue;
	
	@ApiModelProperty(name = "userName", value = "userName")
	@JsonProperty("userName")
	@JacksonXmlProperty(localName = "userName")
	private String userName;
	
	@ApiModelProperty(name = "status", value = "status")
	@JsonProperty("status")
	@JacksonXmlProperty(localName = "status")
	private String status;
	
	@ApiModelProperty(name = "registeredUser", value = "registeredUser")
	@JsonProperty("registeredUser")
	@JacksonXmlProperty(localName = "registeredUser")
	private String registeredUser;
	
	@ApiModelProperty(name = "userId", value = "userId")
	@JsonProperty("userId")
	@JacksonXmlProperty(localName = "userId")
	private int userId;

	/**
	 * @return the liveChatId
	 */
	public int getLiveChatId() {
		return liveChatId;
	}

	/**
	 * @param liveChatId the liveChatId to set
	 */
	public void setLiveChatId(int liveChatId) {
		this.liveChatId = liveChatId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mobile
	 */
	public int getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the serviceRef
	 */
	public String getServiceRef() {
		return serviceRef;
	}

	/**
	 * @param serviceRef the serviceRef to set
	 */
	public void setServiceRef(String serviceRef) {
		this.serviceRef = serviceRef;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the queue
	 */
	public int getQueue() {
		return queue;
	}

	/**
	 * @param queue the queue to set
	 */
	public void setQueue(int queue) {
		this.queue = queue;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the registeredUser
	 */
	public String getRegisteredUser() {
		return registeredUser;
	}

	/**
	 * @param registeredUser the registeredUser to set
	 */
	public void setRegisteredUser(String registeredUser) {
		this.registeredUser = registeredUser;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
