package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "livechat")
public class LiveChat implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "livechatid")
	private int liveChatId;
	
	@Column(name = "firstname")
	private  String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "mobile")
	private int mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "serviceref")
	private String serviceRef;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "priority")
	private int priority;
	
	@Column(name = "queue")
	private int queue;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "registereduser")
	private String registeredUser;
	
	@Column(name = "userid")
	private int userId;
	
	@Column(name="supportusername")
	private String supportUserName;

	/**
	 * @return the supportUserName
	 */
	public String getSupportUserName() {
		return supportUserName;
	}

	/**
	 * @param supportUserName the supportUserName to set
	 */
	public void setSupportUserName(String supportUserName) {
		this.supportUserName = supportUserName;
	}

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
