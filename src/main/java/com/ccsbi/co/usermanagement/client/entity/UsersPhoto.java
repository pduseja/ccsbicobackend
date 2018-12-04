package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "UsersPhoto")
@JacksonXmlRootElement(localName = "UsersPhoto")
@SuppressWarnings("serial")
public class UsersPhoto implements Serializable {

	@ApiModelProperty(name = "photo", value = "photo")
	@JsonProperty("photo")
	@JacksonXmlProperty(localName = "photo")
	private String photo;
	
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
}
