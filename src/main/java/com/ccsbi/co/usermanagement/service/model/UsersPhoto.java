package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UsersPhoto implements Serializable {

	private int photoId;
	
	private String photo;
	
	private byte[] photoContent;
	
	private String fileType;
	
	private String active;
	
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

}
