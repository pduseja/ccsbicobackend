package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity(name = "usersdetails")
public class UsersDetails implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int Id;

	@Column(name = "userid")
	private int userId;
	
	@Column(name="istemppassword")
	private char isTempPassword;
	
	@Column(name="securityquestionid1")
	private int securityQuestionId1;
	
	@Column(name="securityquestionid2")
	private int securityQuestionId2;
	
	@Column(name="securityanswer1")
	private String SecurityAnswer1;
	
	@Column(name="securityanswer2")
	private String SecurityAnswer2;
	
	@Column (name="password")
	private String password;
	
	@Column(name="memorableword")
	private String memorableWord;
	
	@Column(name="inserted")
	private Date inserted;
	
	@Column(name="moddate")
	private Date modDate;
	
	@OneToOne
	@JoinColumn(name="userid", insertable =false, updatable =false)
	private Users users;

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
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

	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

}
