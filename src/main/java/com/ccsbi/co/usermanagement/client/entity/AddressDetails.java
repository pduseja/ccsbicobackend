package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "AddressDetails")
@JacksonXmlRootElement(localName = "AddressDetails")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class AddressDetails implements Serializable {

	@ApiModelProperty(name = "id", required = true, readOnly = true, value = "The Address ID")
	@JsonProperty("id")
	@JacksonXmlProperty(localName = "id")
	private int id;
	
	@ApiModelProperty(name = "flatNo", value = "flatNo")
	@JsonProperty("flatNo")
	@JacksonXmlProperty(localName = "flatNo")
	private String flatNo;
	
	@ApiModelProperty(name = "houseName", value = "houseName")
	@JsonProperty("houseName")
	@JacksonXmlProperty(localName = "houseName")
	private String houseName;
	
	@ApiModelProperty(name = "addressLine1", value = "addressLine1")
	@JsonProperty("addressLine1")
	@JacksonXmlProperty(localName = "addressLine1")
	private String addressLine1;
	
	@ApiModelProperty(name = "addressLine2", value = "addressLine2")
	@JsonProperty("addressLine2")
	@JacksonXmlProperty(localName = "addressLine2")
	private String addressLine2;
	
	@ApiModelProperty(name = "addressLine3", value = "addressLine3")
	@JsonProperty("addressLine3")
	@JacksonXmlProperty(localName = "addressLine3")
	private String addressLine3;
	
	@ApiModelProperty(name = "cityTown", value = "cityTown")
	@JsonProperty("cityTown")
	@JacksonXmlProperty(localName = "cityTown")
	private String cityTown;
	
	@ApiModelProperty(name = "stateProvince", value = "stateProvince")
	@JsonProperty("stateProvince")
	@JacksonXmlProperty(localName = "stateProvince")
	private String stateProvince;
	
	@ApiModelProperty(name = "country", value = "country")
	@JsonProperty("country")
	@JacksonXmlProperty(localName = "country")
	private String country;
	
	@ApiModelProperty(name = "pinPostCode", value = "pinPostCode")
	@JsonProperty("pinPostCode")
	@JacksonXmlProperty(localName = "pinPostCode")
	private String pinPostCode;
	
	@ApiModelProperty(name = "type", value = "type")
	@JsonProperty("type")
	@JacksonXmlProperty(localName = "type")
	private String type;
	
	@ApiModelProperty(name = "active", value = "active")
	@JsonProperty("active")
	@JacksonXmlProperty(localName = "active")
	private String active;
	
	@ApiModelProperty(name = "sysDate", value = "sysDate")
	@JsonProperty("sysDate")
	@JacksonXmlProperty(localName = "sysDate")
	private Date sysDate;
	
	@ApiModelProperty(name = "modDate", value = "modDate")
	@JsonProperty("modDate")
	@JacksonXmlProperty(localName = "modDate")
	private Date modDate;
	
	@ApiModelProperty(name = "mobile", value = "mobile")
	@JsonProperty("mobile")
	@JacksonXmlProperty(localName = "mobile")
	private String mobile;
	
	@ApiModelProperty(name = "landline", value = "landline")
	@JsonProperty("landline")
	@JacksonXmlProperty(localName = "landline")
	private String landline;
	
	@ApiModelProperty(name = "email", value = "email")
	@JsonProperty("email")
	@JacksonXmlProperty(localName = "email")
	private String email;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the flatNo
	 */
	public String getFlatNo() {
		return flatNo;
	}

	/**
	 * @param flatNo the flatNo to set
	 */
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	/**
	 * @return the houseName
	 */
	public String getHouseName() {
		return houseName;
	}

	/**
	 * @param houseName the houseName to set
	 */
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * @return the cityTown
	 */
	public String getCityTown() {
		return cityTown;
	}

	/**
	 * @param cityTown the cityTown to set
	 */
	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	/**
	 * @return the stateProvince
	 */
	public String getStateProvince() {
		return stateProvince;
	}

	/**
	 * @param stateProvince the stateProvince to set
	 */
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pinPostCode
	 */
	public String getPinPostCode() {
		return pinPostCode;
	}

	/**
	 * @param pinPostCode the pinPostCode to set
	 */
	public void setPinPostCode(String pinPostCode) {
		this.pinPostCode = pinPostCode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the landline
	 */
	public String getLandline() {
		return landline;
	}

	/**
	 * @param landline the landline to set
	 */
	public void setLandline(String landline) {
		this.landline = landline;
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
	
}
