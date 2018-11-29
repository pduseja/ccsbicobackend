package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Users")
@JacksonXmlRootElement(localName = "Users")
@SuppressWarnings("serial")
public class Users implements Serializable{

	@ApiModelProperty(name = "userId", required = true, readOnly = true, value = "The User ID")
	@JsonProperty("userId")
	@JacksonXmlProperty(localName = "userId")
	private int userId;

	@ApiModelProperty(name = "userName", value = "userName")
	@JsonProperty("userName")
	@JacksonXmlProperty(localName = "userName")
	private String userName;
	
	@ApiModelProperty(name = "usersDetails", value = "usersDetails")
	@JsonProperty("usersDetails")
	@JacksonXmlProperty(localName = "usersDetails")
	private Object usersDetails;

	@ApiModelProperty(name = "title", value = "title")
	@JsonProperty("title")
	@JacksonXmlProperty(localName = "title")
	private String title;

	@ApiModelProperty(name = "firstName", value = "firstName")
	@JsonProperty("firstName")
	@JacksonXmlProperty(localName = "firstName")
	private String firstName;

	@ApiModelProperty(name = "middleName", value = "middleName")
	@JsonProperty("middleName")
	@JacksonXmlProperty(localName = "middleName")
	private String middleName;

	@ApiModelProperty(name = "lastName", value = "lastName")
	@JsonProperty("lastName")
	@JacksonXmlProperty(localName = "lastName")
	private String lastName;

	@ApiModelProperty(name = "photoId", value = "photoId")
	@JsonProperty("photoId")
	@JacksonXmlProperty(localName = "photoId")
	private int photoId;

	@ApiModelProperty(name = "gender", value = "gender")
	@JsonProperty("gender")
	@JacksonXmlProperty(localName = "gender")
	private String gender;

	@ApiModelProperty(name = "townOfBirth", value = "townOfBirth")
	@JsonProperty("townOfBirth")
	@JacksonXmlProperty(localName = "townOfBirth")
	private String townOfBirth;

	@ApiModelProperty(name = "countryOfBirth", value = "countryOfBirth")
	@JsonProperty("countryOfBirth")
	@JacksonXmlProperty(localName = "countryOfBirth")
	private String countryOfBirth;

	@ApiModelProperty(name = "permAId", value = "permAId")
	@JsonProperty("permAId")
	@JacksonXmlProperty(localName = "permAId")
	private String permAId;

	@ApiModelProperty(name = "tempAId", value = "tempAId")
	@JsonProperty("tempAId")
	@JacksonXmlProperty(localName = "tempAId")
	private String tempAId;

	@ApiModelProperty(name = "workAId", value = "workAId")
	@JsonProperty("workAId")
	@JacksonXmlProperty(localName = "workAId")
	private String workAId;

	@ApiModelProperty(name = "billAId", value = "billAId")
	@JsonProperty("billAId")
	@JacksonXmlProperty(localName = "billAId")
	private String billAId;
	
	@ApiModelProperty(name = "dateofbirth", value = "dateofbirth")
	@JsonProperty("dateofbirth")
	@JacksonXmlProperty(localName = "dateofbirth")
	private Date dateofbirth;

	@ApiModelProperty(name = "fatherId", value = "fatherId")
	@JsonProperty("fatherId")
	@JacksonXmlProperty(localName = "fatherId")
	private String nationality;

	@ApiModelProperty(name = "fatherId", value = "fatherId")
	@JsonProperty("fatherId")
	@JacksonXmlProperty(localName = "fatherId")
	private String fatherId;

	@ApiModelProperty(name = "motherId", value = "motherId")
	@JsonProperty("motherId")
	@JacksonXmlProperty(localName = "motherId")
	private String motherId;

	@ApiModelProperty(name = "secDetId", value = "secDetId")
	@JsonProperty("secDetId")
	@JacksonXmlProperty(localName = "secDetId")
	private String secDetId;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	 * @return the photoId
	 */
	public int getPhotoId() {
		return photoId;
	}

	/**
	 * @param photoId the photoId to set
	 */
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the townOfBirth
	 */
	public String getTownOfBirth() {
		return townOfBirth;
	}

	/**
	 * @param townOfBirth the townOfBirth to set
	 */
	public void setTownOfBirth(String townOfBirth) {
		this.townOfBirth = townOfBirth;
	}

	/**
	 * @return the countryOfBirth
	 */
	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	/**
	 * @param countryOfBirth the countryOfBirth to set
	 */
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	/**
	 * @return the permAId
	 */
	public String getPermAId() {
		return permAId;
	}

	/**
	 * @param permAId the permAId to set
	 */
	public void setPermAId(String permAId) {
		this.permAId = permAId;
	}

	/**
	 * @return the tempAId
	 */
	public String getTempAId() {
		return tempAId;
	}

	/**
	 * @param tempAId the tempAId to set
	 */
	public void setTempAId(String tempAId) {
		this.tempAId = tempAId;
	}

	/**
	 * @return the workAId
	 */
	public String getWorkAId() {
		return workAId;
	}

	/**
	 * @param workAId the workAId to set
	 */
	public void setWorkAId(String workAId) {
		this.workAId = workAId;
	}

	/**
	 * @return the billAId
	 */
	public String getBillAId() {
		return billAId;
	}

	/**
	 * @param billAId the billAId to set
	 */
	public void setBillAId(String billAId) {
		this.billAId = billAId;
	}

	/**
	 * @return the dateofbirth
	 */
	public Date getDateofbirth() {
		return dateofbirth;
	}

	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the fatherId
	 */
	public String getFatherId() {
		return fatherId;
	}

	/**
	 * @param fatherId the fatherId to set
	 */
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	/**
	 * @return the motherId
	 */
	public String getMotherId() {
		return motherId;
	}

	/**
	 * @param motherId the motherId to set
	 */
	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}

	/**
	 * @return the secDetId
	 */
	public String getSecDetId() {
		return secDetId;
	}

	/**
	 * @param secDetId the secDetId to set
	 */
	public void setSecDetId(String secDetId) {
		this.secDetId = secDetId;
	}

}
