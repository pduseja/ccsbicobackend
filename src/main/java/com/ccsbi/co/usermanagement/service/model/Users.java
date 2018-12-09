package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Users implements Serializable {

	private int userId;

	private String userName;

	private String title;

	private String firstName;

	private String middleName;

	private String lastName;

	private int photoId;

	private String gender;

	private String townOfBirth;

	private String countryOfBirth;

	private Date dateofbirth;

	private String nationality;

	private String fatherId;

	private String motherId;
	
	private UsersDetails usersDetails;
	
	private UsersPhoto usersPhoto;
	
	private List<AddressDetails> addressDetailsList;
	
	private UsersLoginRecord usersLoginRecord;

	/**
	 * @return the addressDetailsList
	 */
	public List<AddressDetails> getAddressDetailsList() {
		return addressDetailsList;
	}

	/**
	 * @param addressDetailsList the addressDetailsList to set
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
	 * @param usersLoginRecord the usersLoginRecord to set
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
	 * @return the usersDetails
	 */
	public UsersDetails getUsersDetails() {
		return usersDetails;
	}

	/**
	 * @param usersDetails the usersDetails to set
	 */
	public void setUsersDetails(UsersDetails usersDetails) {
		this.usersDetails = usersDetails;
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
	 * @param usersPhoto the usersPhoto to set
	 */
	public void setUsersPhoto(UsersPhoto usersPhoto) {
		this.usersPhoto = usersPhoto;
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

}
