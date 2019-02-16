package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "IMessage")
@JacksonXmlRootElement(localName = "IMessage")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class IMessage implements Serializable {

	@ApiModelProperty(name = "iMessageId", required = true, readOnly = true, value = "Message request number")
	@JsonProperty("iMessageId")
	@JacksonXmlProperty(localName = "iMessageId")
	private int iMessageId;

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

	@ApiModelProperty(name = "lastName", value = "lastName")
	@JsonProperty("lastName")
	@JacksonXmlProperty(localName = "lastName")
	private String lastName;

	@ApiModelProperty(name = "department", value = "department")
	@JsonProperty("department")
	@JacksonXmlProperty(localName = "department")
	private String department;

	@ApiModelProperty(name = "isExistingCustomer", value = "isExistingCustomer")
	@JsonProperty("isExistingCustomer")
	@JacksonXmlProperty(localName = "isExistingCustomer")
	private String isExistingCustomer;

	@ApiModelProperty(name = "serviceRef", value = "serviceRef")
	@JsonProperty("serviceRef")
	@JacksonXmlProperty(localName = "serviceRef")
	private String serviceRef;

	@ApiModelProperty(name = "methodOfContact", value = "methodOfContact")
	@JsonProperty("methodOfContact")
	@JacksonXmlProperty(localName = "methodOfContact")
	private String methodOfContact;

	@ApiModelProperty(name = "landlinePhone", value = "landlinePhone")
	@JsonProperty("landlinePhone")
	@JacksonXmlProperty(localName = "landlinePhone")
	private int landlinePhone;

	@ApiModelProperty(name = "mobile", value = "mobile")
	@JsonProperty("mobile")
	@JacksonXmlProperty(localName = "mobile")
	private int mobile;

	@ApiModelProperty(name = "email", value = "email")
	@JsonProperty("email")
	@JacksonXmlProperty(localName = "email")
	private String email;

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

	@ApiModelProperty(name = "responseStatus", value = "responseStatus")
	@JsonProperty("responseStatus")
	@JacksonXmlProperty(localName = "responseStatus")
	private String responseStatus;

	@ApiModelProperty(name = "messageReply", value = "messageReply")
	@JsonProperty("messageReply")
	@JacksonXmlProperty(localName = "messageReply")
	private String messageReply;

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

	@ApiModelProperty(name = "IMessageFollowUpList", value = "IMessageFollowUpList")
	@JsonProperty("IMessageFollowUpList")
	@JacksonXmlProperty(localName = "IMessageFollowUpList")
	private List<IMessageFollowUp> iMessageFollowUpList;

	/**
	 * @return the iMessageFollowUpList
	 */
	public List<IMessageFollowUp> getiMessageFollowUpList() {
		return iMessageFollowUpList;
	}

	/**
	 * @param iMessageFollowUpList
	 *            the iMessageFollowUpList to set
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
	 * @param iMessageId
	 *            the iMessageId to set
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
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
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
	 * @param isExistingCustomer
	 *            the isExistingCustomer to set
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
	 * @param serviceRef
	 *            the serviceRef to set
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
	 * @param methodOfContact
	 *            the methodOfContact to set
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
	 * @param landlinePhone
	 *            the landlinePhone to set
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
	 * @param mobile
	 *            the mobile to set
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
	 * @param email
	 *            the email to set
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
	 * @return the messageReply
	 */
	public String getMessageReply() {
		return messageReply;
	}

	/**
	 * @param messageReply
	 *            the messageReply to set
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
