package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "userid")
	private int userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "title")
	private String title;
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "middlename")
	private String middleName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "photoid")
	private int photoId;

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "townofbirth")
	private String townOfBirth;
	
	@Column(name="countryofbirth")
	private String countryOfBirth;

	@Column(name = "permaid")
	private String permAId;
	
	@Column(name = "tempaid")
	private String TempAId;
	
	@Column(name = "workaid")
	private String WorkAId;
	
	@Column(name = "billaid")
	private String BillAId;
	
	@Column(name = "dob")
	private Date dateofbirth;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "fatherid")
	private String fatherId;

	@Column(name = "motherid")
	private String motherId;

	@Column(name="secdetid")
	private String secDetId;
	
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
		return TempAId;
	}

	/**
	 * @param tempAId the tempAId to set
	 */
	public void setTempAId(String tempAId) {
		TempAId = tempAId;
	}

	/**
	 * @return the workAId
	 */
	public String getWorkAId() {
		return WorkAId;
	}

	/**
	 * @param workAId the workAId to set
	 */
	public void setWorkAId(String workAId) {
		WorkAId = workAId;
	}

	/**
	 * @return the billAId
	 */
	public String getBillAId() {
		return BillAId;
	}

	/**
	 * @param billAId the billAId to set
	 */
	public void setBillAId(String billAId) {
		BillAId = billAId;
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
	 * @param photo the photoId to set
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
	 * @param hintAnswer the townOfBirth to set
	 */
	public void setTownOfBirth(String townOfBirth) {
		this.townOfBirth = townOfBirth;
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
	
}
