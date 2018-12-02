package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "UsersLoginRecord")
@JacksonXmlRootElement(localName = "UsersLoginRecord")
@SuppressWarnings("serial")
public class UsersLoginRecord implements Serializable{


	@ApiModelProperty(name = "userName", value = "userName")
	@JsonProperty("userName")
	@JacksonXmlProperty(localName = "userName")
	private String userName;
	
	@ApiModelProperty(name = "password", value = "password")
	@JsonProperty("password")
	@JacksonXmlProperty(localName = "password") 
	private String password;
	
	@ApiModelProperty(name = "rememberMe", value = "rememberMe")
	@JsonProperty("rememberMe")
	@JacksonXmlProperty(localName = "rememberMe") 
	private Boolean rememberMe;
	
	@ApiModelProperty(name = "token", value = "token")
	@JsonProperty("token")
	@JacksonXmlProperty(localName = "token") 
	private String token;

	
	@ApiModelProperty(name = "name", value = "name")
	@JsonProperty("name")
	@JacksonXmlProperty(localName = "name")
	private String name;
	
	@ApiModelProperty(name = "cookie", value = "cookie")
	@JsonProperty("cookie")
	@JacksonXmlProperty(localName = "cookie")
	private String cookie;
	
	@ApiModelProperty(name = "cookieExpirytime", value = "cookieExpirytime")
	@JsonProperty("cookieExpirytime")
	@JacksonXmlProperty(localName = "cookieExpirytime")
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
