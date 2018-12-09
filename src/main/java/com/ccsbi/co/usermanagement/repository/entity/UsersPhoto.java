package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;

@SuppressWarnings("serial")
@Entity(name = "usersphoto")
public class UsersPhoto implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "photoid")
	private int photoId;
	
	@Column(name = "photo")
	private String photo;
	
	@Lob 
	@Column(name = "PhotoContent" , columnDefinition="BINARY(500000)")
	private byte[] photoContent;
	
	@Column(name = "fileType")
	private String fileType;
	
	@Column(name = "active")
	private String active;
	
	@Column(name = "sysdate")
	private Date sysDate;

	/**
	 * @return the photoContent
	 */
	public byte[] getPhotoContent() {
		return photoContent;
	}

	/**
	 * @param photoContent the photoContent to set
	 */
	public void setPhotoContent(byte[] photoContent) {
		this.photoContent = photoContent;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the sysDate
	 */
	public Date getSysDate() {
		return sysDate;
	}

	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
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
	
	@PrePersist
	private void prePersist() {
		Date rightNow = new Date(Calendar.getInstance().getTime().getTime());
		this.sysDate = Optional.ofNullable(this.getSysDate()).orElse(rightNow);
	}

}
