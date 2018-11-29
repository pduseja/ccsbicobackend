package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UsersLoginRecord implements Serializable{

	private String userName;
	
	private String password;
	
	private Boolean rememberMe;
	
	private String name;
	
	private String token;
	
	private String cookie;
	
	private int cookieExpirytime;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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


}
