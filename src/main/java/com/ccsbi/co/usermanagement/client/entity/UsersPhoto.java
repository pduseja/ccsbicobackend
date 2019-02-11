package com.ccsbi.co.usermanagement.client.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "UsersPhoto")
@JacksonXmlRootElement(localName = "UsersPhoto")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class UsersPhoto implements Serializable {

	private int photoId;
	
	@ApiModelProperty(name = "photo", value = "photo")
	@JsonProperty("photo")
	@JacksonXmlProperty(localName = "photo")
	private File photo;
	
	/**
	 * @return the photo
	 */
	public File getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	@ApiModelProperty(name = "photoContent", value = "photoContent")
	@JsonProperty("photoContent")
	@JacksonXmlProperty(localName = "photoContent")
	private byte[] photoContent;
	
	@ApiModelProperty(name = "fileType", value = "fileType")
	@JsonProperty("fileType")
	@JacksonXmlProperty(localName = "fileType")
	private String fileType;
	
	@ApiModelProperty(name = "active", value = "active")
	@JsonProperty("active")
	@JacksonXmlProperty(localName = "active")
	private String active;
	
	@ApiModelProperty(name = "sysDate", value = "sysDate")
	@JsonProperty("sysDate")
	@JacksonXmlProperty(localName = "sysDate")
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
