package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


@SuppressWarnings("serial")
public class IMessage implements Serializable {
	
	private int iMessageId;
	
	private String userName;
	
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String department;
	
	private String isExistingCustomer;
	
	private String serviceRef;
	
	private String methodOfContact;
	
	private int landlinePhone;
	
	private int mobile;
	
	private String email;
	
	private String subject;
	
	private String message;
	
	private String fileAttached;
	
	private byte[] fileContent;
	
	private String wasSignedIn;
	
	private String responseStatus;
	
	private String messageReply;
	
	private String readStatus;
	
	private String crBy;
	
	private Date sysDate;
	
	private String modBy;
	
	private Date modDate;

	private List<IMessageFollowUp> iMessageFollowUpList;
	
	/**
	 * @return the iMessageFollowUpList
	 */
	public List<IMessageFollowUp> getiMessageFollowUpList() {
		return iMessageFollowUpList;
	}

	/**
	 * @param iMessageFollowUpList the iMessageFollowUpList to set
	 */
	public void setiMessageFollowUpList(List<IMessageFollowUp> iMessageFollowUpList) {
		this.iMessageFollowUpList = iMessageFollowUpList;
	}

	/**
	 * @return the iMessageId
	 */
	public int getiMessageId() {
		return iMessageId;
	}

	/**
	 * @param iMessageId the iMessageId to set
	 */
	public void setiMessageId(int iMessageId) {
		this.iMessageId = iMessageId;
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
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the isExistingCustomer
	 */
	public String getIsExistingCustomer() {
		return isExistingCustomer;
	}

	/**
	 * @param isExistingCustomer the isExistingCustomer to set
	 */
	public void setIsExistingCustomer(String isExistingCustomer) {
		this.isExistingCustomer = isExistingCustomer;
	}

	/**
	 * @return the serviceRef
	 */
	public String getServiceRef() {
		return serviceRef;
	}

	/**
	 * @param serviceRef the serviceRef to set
	 */
	public void setServiceRef(String serviceRef) {
		this.serviceRef = serviceRef;
	}

	/**
	 * @return the methodOfContact
	 */
	public String getMethodOfContact() {
		return methodOfContact;
	}

	/**
	 * @param methodOfContact the methodOfContact to set
	 */
	public void setMethodOfContact(String methodOfContact) {
		this.methodOfContact = methodOfContact;
	}

	/**
	 * @return the landlinePhone
	 */
	public int getLandlinePhone() {
		return landlinePhone;
	}

	/**
	 * @param landlinePhone the landlinePhone to set
	 */
	public void setLandlinePhone(int landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	/**
	 * @return the mobile
	 */
	public int getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
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
	 * @param message the message to set
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
	 * @param fileAttached the fileAttached to set
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
	 * @param fileContent the fileContent to set
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
	 * @param wasSignedIn the wasSignedIn to set
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
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return the messageReply
	 */
	public String getMessageReply() {
		return messageReply;
	}

	/**
	 * @param messageReply the messageReply to set
	 */
	public void setMessageReply(String messageReply) {
		this.messageReply = messageReply;
	}

	/**
	 * @return the readStatus
	 */
	public String getReadStatus() {
		return readStatus;
	}

	/**
	 * @param readStatus the readStatus to set
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
	 * @param crBy the crBy to set
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
	 * @param sysDate the sysDate to set
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
	 * @param modBy the modBy to set
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
	 * @param modDate the modDate to set
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
		return Objects.hash(this.iMessageId);
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

		IMessage rhs = (IMessage) obj;
		return new EqualsBuilder().append(this.iMessageId, rhs.iMessageId).isEquals();
	}


}
