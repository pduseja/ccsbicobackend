package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LiveChatMembers implements Serializable {
		
	private int liveChatMembersId;
	
	private String firstName;
	
	private String department;
	
	private String status;
	
	private int queue;
	
	private String userName;
	
	private int priority;
	
	private String addNumber;

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
