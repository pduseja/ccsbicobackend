package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class IMessageFollowUp implements Serializable {

	private int iMessageFollowUpId;

	private int iMessageId;

	private String subject;

	private String message;

	private String fileAttached;

	private byte[] fileContent;

	private String wasSignedIn;

	private String responseStatus;

	private String messageStatus;

	private String readStatus;

	private String crBy;

	private Date sysDate;

	private String modBy;

	private Date modDate;

	private IMessage iMessage;

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
	 * @return the fileAttached
	 */
	public String getFileAttached() {
		return fileAttached;
	}

	/**
	 * @param fileAttached
	 *            the fileAttached to set
	 */
	public void setFileAttached(String fileAttached) {
		this.fileAttached = fileAttached;
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

	/**
	 * @return the iMessage
	 */
	public IMessage getiMessage() {
		return iMessage;
	}

	/**
	 * @param iMessage
	 *            the iMessage to set
	 */
	public void setiMessage(IMessage iMessage) {
		this.iMessage = iMessage;
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
