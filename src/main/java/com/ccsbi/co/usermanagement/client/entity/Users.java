package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Users")
@JacksonXmlRootElement(localName = "Users")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class Users implements Serializable {

	@ApiModelProperty(name = "userId", required = true, readOnly = true, value = "The User ID")
	@JsonProperty("userId")
	@JacksonXmlProperty(localName = "userId")
	private int userId;

	@ApiModelProperty(name = "userName", value = "userName")
	@JsonProperty("userName")
	@JacksonXmlProperty(localName = "userName")
	private String userName;

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

	@ApiModelProperty(name = "dateofbirth", value = "dateofbirth")
	@JsonProperty("dateofbirth")
	@JacksonXmlProperty(localName = "dateofbirth")
	private Date dateofbirth;

	@ApiModelProperty(name = "nationality", value = "nationality")
	@JsonProperty("nationality")
	@JacksonXmlProperty(localName = "nationality")
	private String nationality;

	@ApiModelProperty(name = "fatherId", value = "fatherId")
	@JsonProperty("fatherId")
	@JacksonXmlProperty(localName = "fatherId")
	private String fatherId;

	@ApiModelProperty(name = "motherId", value = "motherId")
	@JsonProperty("motherId")
	@JacksonXmlProperty(localName = "motherId")
	private String motherId;

	@ApiModelProperty(name = "active", value = "active")
	@JsonProperty("active")
	@JacksonXmlProperty(localName = "active")
	private String active;

	@ApiModelProperty(name = "UsersPhoto", value = "UsersPhoto")
	@JsonProperty("UsersPhoto")
	@JacksonXmlProperty(localName = "UsersPhoto")
	private UsersPhoto usersPhoto;

	@ApiModelProperty(name = "AddressDetailsList", value = "AddressDetailsList")
	@JsonProperty("AddressDetailsList")
	@JacksonXmlProperty(localName = "AddressDetailsList")
	private List<AddressDetails> addressDetailsList;

	@ApiModelProperty(name = "UsersLoginRecord", value = "UsersLoginRecord")
	@JsonProperty("UsersLoginRecord")
	@JacksonXmlProperty(localName = "UsersLoginRecord")
	private UsersLoginRecord usersLoginRecord;

	@ApiModelProperty(name = "UsersDetails", value = "UsersDetails")
	@JsonProperty("UsersDetails")
	@JacksonXmlProperty(localName = "UsersDetails")
	private UsersDetails usersDetails;

	@ApiModelProperty(name = "profileId", value = "profileId")
	@JsonProperty("profileId")
	@JacksonXmlProperty(localName = "profileId")
	private int profileId;

	public Users() {
		super();
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId
	 *            the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the addressDetailsList
	 */
	public List<AddressDetails> getAddressDetailsList() {
		return addressDetailsList;
	}

	/**
	 * @param addressDetailsList
	 *            the addressDetailsList to set
	 */
	public void setAddressDetailsList(List<AddressDetails> addressDetailsList) {
		this.addressDetailsList = addressDetailsList;
	}

	/**
	 * @return the usersLoginRecord
	 */
	public UsersLoginRecord getUsersLoginRecord() {
		return usersLoginRecord;
	}

	/**
	 * @param usersLoginRecord
	 *            the usersLoginRecord to set
	 */
	public void setUsersLoginRecord(UsersLoginRecord usersLoginRecord) {
		this.usersLoginRecord = usersLoginRecord;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
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
	 * @param userName
	 *            the userName to set
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
	 * @param title
	 *            the title to set
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
	 * @param firstName
	 *            the firstName to set
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
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the usersDetails
	 */
	public UsersDetails getUsersDetails() {
		return usersDetails;
	}

	/**
	 * @param usersDetails
	 *            the usersDetails to set
	 */
	public void setUsersDetails(UsersDetails usersDetails) {
		this.usersDetails = usersDetails;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
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
	 * @param photoId
	 *            the photoId to set
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
	 * @param gender
	 *            the gender to set
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
	 * @param townOfBirth
	 *            the townOfBirth to set
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
	 * @param countryOfBirth
	 *            the countryOfBirth to set
	 */
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	/**
	 * @return the dateofbirth
	 */
	public Date getDateofbirth() {
		return dateofbirth;
	}

	/**
	 * @return the usersPhoto
	 */
	public UsersPhoto getUsersPhoto() {
		return usersPhoto;
	}

	/**
	 * @param usersPhoto
	 *            the usersPhoto to set
	 */
	public void setUsersPhoto(UsersPhoto usersPhoto) {
		this.usersPhoto = usersPhoto;
	}

	/**
	 * @param dateofbirth
	 *            the dateofbirth to set
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
	 * @param nationality
	 *            the nationality to set
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
	 * @param fatherId
	 *            the fatherId to set
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
	 * @param motherId
	 *            the motherId to set
	 */
	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
