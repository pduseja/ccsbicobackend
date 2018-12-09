package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@SuppressWarnings("serial")
@Entity(name = "usersloginrecord")
public class UsersLoginRecord implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "userlogintrackid")
	private int userLoginTrackID;
	
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "cookieexpirytime")
	private int cookieExpirytime;
	
	@Column(name = "rememberme")
	private Boolean rememberMe;
	
	@Column(name = "cookie")
	private String cookie;
	
	@Column(name = "lastused")
	private Timestamp lastUsed;

	@Column(name = "lastactivetime")
	private long lastActiveTime;
	
	@Column(name = "lastlogouttime")
	private Timestamp lastLogouttime;

	/**
	 * @return the userLoginTrackID
	 */
	public int getUserLoginTrackID() {
		return userLoginTrackID;
	}

	/**
	 * @param userLoginTrackID the userLoginTrackID to set
	 */
	public void setUserLoginTrackID(int userLoginTrackID) {
		this.userLoginTrackID = userLoginTrackID;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the cookieExpirytime
	 */
	public int getCookieExpirytime() {
		return cookieExpirytime;
	}

	/**
	 * @param cookieExpirytime the cookieExpirytime to set
	 */
	public void setCookieExpirytime(int cookieExpirytime) {
		this.cookieExpirytime = cookieExpirytime;
	}

	/**
	 * @return the rememberMe
	 */
	public Boolean getRememberMe() {
		return rememberMe;
	}

	/**
	 * @param rememberMe the rememberMe to set
	 */
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * @return the lastUsed
	 */
	public Timestamp getLastUsed() {
		return lastUsed;
	}

	/**
	 * @param lastUsed the lastUsed to set
	 */
	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	/**
	 * @return the lastActiveTime
	 */
	public long getLastActiveTime() {
		return lastActiveTime;
	}

	/**
	 * @param lastActiveTime the lastActiveTime to set
	 */
	public void setLastActiveTime(long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	/**
	 * @return the lastLogouttime
	 */
	public Timestamp getLastLogouttime() {
		return lastLogouttime;
	}

	/**
	 * @param lastLogouttime the lastLogouttime to set
	 */
	public void setLastLogouttime(Timestamp lastLogouttime) {
		this.lastLogouttime = lastLogouttime;
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
	
	@PrePersist
	private void prePersist() {		
		this.lastLogouttime = Optional.ofNullable(this.getLastLogouttime()).orElse(new Timestamp(System.currentTimeMillis()));
		this.lastUsed = Optional.ofNullable(this.getLastUsed()).orElse(new Timestamp(System.currentTimeMillis()));
	}
}
