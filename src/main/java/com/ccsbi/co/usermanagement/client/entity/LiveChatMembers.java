package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "LiveChatMembers")
@JacksonXmlRootElement(localName = "LiveChatMembers")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class LiveChatMembers implements Serializable {
	
	@ApiModelProperty(name = "liveChatMembersId", required = true, readOnly = true, value = "LiveChatMembers ID")
	@JsonProperty("liveChatMembersId")
	@JacksonXmlProperty(localName = "liveChatMembersId")
	private int liveChatMembersId;

	@ApiModelProperty(name = "firstName", value = "firstName")
	@JsonProperty("firstName")
	@JacksonXmlProperty(localName = "firstName")
	private String firstName;

	@ApiModelProperty(name = "department", value = "department")
	@JsonProperty("department")
	@JacksonXmlProperty(localName = "department")
	private String department;

	@ApiModelProperty(name = "status", value = "status")
	@JsonProperty("status")
	@JacksonXmlProperty(localName = "status")
	private String status;

	@ApiModelProperty(name = "queue", value = "queue")
	@JsonProperty("queue")
	@JacksonXmlProperty(localName = "queue")
	private int queue;

	@ApiModelProperty(name = "userName", value = "userName")
	@JsonProperty("userName")
	@JacksonXmlProperty(localName = "userName")
	private String userName;

	@ApiModelProperty(name = "priority", value = "priority")
	@JsonProperty("priority")
	@JacksonXmlProperty(localName = "priority")
	private int priority;

	@ApiModelProperty(name = "addNumber", value = "addNumber")
	@JsonProperty("addNumber")
	@JacksonXmlProperty(localName = "addNumber")
	private String addNumber;
	
	@ApiModelProperty(name = "chatMember", value = "chatMember")
	@JsonProperty("chatMember")
	@JacksonXmlProperty(localName = "chatMember")
	private String chatMember;
	
	/**
	 * @return the chatMember
	 */
	public String getChatMember() {
		return chatMember;
	}

	/**
	 * @param chatMember the chatMember to set
	 */
	public void setChatMember(String chatMember) {
		this.chatMember = chatMember;
	}

	/**
	 * @return the addNumber
	 */
	public String getAddNumber() {
		return addNumber;
	}

	/**
	 * @param addNumber the addNumber to set
	 */
	public void setAddNumber(String addNumber) {
		this.addNumber = addNumber;
	}

	/**
	 * @return the liveChatMembersId
	 */
	public int getLiveChatMembersId() {
		return liveChatMembersId;
	}

	/**
	 * @param liveChatMembersId the liveChatMembersId to set
	 */
	public void setLiveChatMembersId(int liveChatMembersId) {
		this.liveChatMembersId = liveChatMembersId;
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


}
