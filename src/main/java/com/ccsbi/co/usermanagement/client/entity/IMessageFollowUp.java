package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "IMessageFollowUp")
@JacksonXmlRootElement(localName = "IMessageFollowUp")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class IMessageFollowUp implements Serializable {

	@ApiModelProperty(name = "iMessageFollowUpId", required = true, readOnly = true, value = "Follow Up Message request number")
	@JsonProperty("iMessageFollowUpId")
	@JacksonXmlProperty(localName = "iMessageFollowUpId")
	private int iMessageFollowUpId;

	@ApiModelProperty(name = "iMessageId", required = true, readOnly = true, value = "Message request number")
	@JsonProperty("iMessageId")
	@JacksonXmlProperty(localName = "iMessageId")
	private int iMessageId;
	@ApiModelProperty(name = "subject", value = "subject")
	@JsonProperty("subject")
	@JacksonXmlProperty(localName = "subject")
	private String subject;

	@ApiModelProperty(name = "message", value = "message")
	@JsonProperty("message")
	@JacksonXmlProperty(localName = "message")
	private String message;

	@ApiModelProperty(name = "fileattached", value = "fileattached")
	@JsonProperty("fileattached")
	@JacksonXmlProperty(localName = "fileattached")
	private String fileattached;

	@ApiModelProperty(name = "fileContent", value = "fileContent")
	@JsonProperty("fileContent")
	@JacksonXmlProperty(localName = "fileContent")
	private byte[] fileContent;

	@ApiModelProperty(name = "wasSignedIn", value = "wasSignedIn")
	@JsonProperty("wasSignedIn")
	@JacksonXmlProperty(localName = "wasSignedIn")
	private String wasSignedIn;

	@ApiModelProperty(name = "followUpTicketId", value = "followUpTicketId")
	@JsonProperty("followUpTicketId")
	@JacksonXmlProperty(localName = "followUpTicketId")
	private int followUpTicketId;

	@ApiModelProperty(name = "responseStatus", value = "responseStatus")
	@JsonProperty("responseStatus")
	@JacksonXmlProperty(localName = "responseStatus")
	private String responseStatus;

	@ApiModelProperty(name = "messageStatus", value = "messageStatus")
	@JsonProperty("messageStatus")
	@JacksonXmlProperty(localName = "messageStatus")
	private String messageStatus;

	@ApiModelProperty(name = "readStatus", value = "readStatus")
	@JsonProperty("readStatus")
	@JacksonXmlProperty(localName = "readStatus")
	private String readStatus;

	@ApiModelProperty(name = "crBy", value = "crBy")
	@JsonProperty("crBy")
	@JacksonXmlProperty(localName = "crBy")
	private String crBy;

	@ApiModelProperty(name = "sysDate", value = "sysDate")
	@JsonProperty("sysDate")
	@JacksonXmlProperty(localName = "sysDate")
	private Date sysDate;

	@ApiModelProperty(name = "modBy", value = "modBy")
	@JsonProperty("modBy")
	@JacksonXmlProperty(localName = "modBy")
	private String modBy;

	@ApiModelProperty(name = "modDate", value = "modDate")
	@JsonProperty("modDate")
	@JacksonXmlProperty(localName = "modDate")
	private Date modDate;

	/**
	 * @return the iMessageFollowUpId
	 */
	public int getiMessageFollowUpId() {
		return iMessageFollowUpId;
	}

	/**
	 * @param iMessageFollowUpId
	 *            the iMessageFollowUpId to set
	 */
	public void setiMessageFollowUpId(int iMessageFollowUpId) {
		this.iMessageFollowUpId = iMessageFollowUpId;
	}

	/**
	 * @return the iMessageId
	 */
	public int getiMessageId() {
		return iMessageId;
	}

	/**
	 * @param iMessageId
	 *            the iMessageId to set
	 */
	public void setiMessageId(int iMessageId) {
		this.iMessageId = iMessageId;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the fileattached
	 */
	public String getFileattached() {
		return fileattached;
	}

	/**
	 * @param fileattached
	 *            the fileattached to set
	 */
	public void setFileattached(String fileattached) {
		this.fileattached = fileattached;
	}

	/**
	 * @return the fileContent
	 */
	public byte[] getFileContent() {
		return fileContent;
	}

	/**
	 * @param fileContent
	 *            the fileContent to set
	 */
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	/**
	 * @return the wasSignedIn
	 */
	public String getWasSignedIn() {
		return wasSignedIn;
	}

	/**
	 * @param wasSignedIn
	 *            the wasSignedIn to set
	 */
	public void setWasSignedIn(String wasSignedIn) {
		this.wasSignedIn = wasSignedIn;
	}

	/**
	 * @return the followUpTicketId
	 */
	public int getFollowUpTicketId() {
		return followUpTicketId;
	}

	/**
	 * @param followUpTicketId
	 *            the followUpTicketId to set
	 */
	public void setFollowUpTicketId(int followUpTicketId) {
		this.followUpTicketId = followUpTicketId;
	}

	/**
	 * @return the responseStatus
	 */
	public String getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus
	 *            the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return the messageStatus
	 */
	public String getMessageStatus() {
		return messageStatus;
	}

	/**
	 * @param messageStatus
	 *            the messageStatus to set
	 */
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	/**
	 * @return the readStatus
	 */
	public String getReadStatus() {
		return readStatus;
	}

	/**
	 * @param readStatus
	 *            the readStatus to set
	 */
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	/**
	 * @return the crBy
	 */
	public String getCrBy() {
		return crBy;
	}

	/**
	 * @param crBy
	 *            the crBy to set
	 */
	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}

	/**
	 * @return the sysDate
	 */
	public Date getSysDate() {
		return sysDate;
	}

	/**
	 * @param sysDate
	 *            the sysDate to set
	 */
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	/**
	 * @return the modBy
	 */
	public String getModBy() {
		return modBy;
	}

	/**
	 * @param modBy
	 *            the modBy to set
	 */
	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	/**
	 * @return the modDate
	 */
	public Date getModDate() {
		return modDate;
	}

	/**
	 * @param modDate
	 *            the modDate to set
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.iMessageFollowUpId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj.getClass() != getClass()) {
			return false;
		}

		IMessageFollowUp rhs = (IMessageFollowUp) obj;
		return new EqualsBuilder().append(this.iMessageFollowUpId, rhs.iMessageFollowUpId).isEquals();
	}
}
