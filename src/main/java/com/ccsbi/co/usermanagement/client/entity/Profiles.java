package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "profiles")
@JacksonXmlRootElement(localName = "profiles")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class Profiles implements Serializable{
	
	@ApiModelProperty(name = "id", required = true, readOnly = true, value = "The User ID")
	@JsonProperty("id")
	@JacksonXmlProperty(localName = "id")
	private int id;

	@ApiModelProperty(name = "Profile", value = "Profile")
	@JsonProperty("Profile")
	@JacksonXmlProperty(localName = "Profile")
	private String profile;	

	@ApiModelProperty(name = "pClass", value = "pClass")
	@JsonProperty("pClass")
	@JacksonXmlProperty(localName = "pClass")
	private String pClass;

	@ApiModelProperty(name = "Template", value = "Template")
	@JsonProperty("Template")
	@JacksonXmlProperty(localName = "Template")
	private String template;

	@ApiModelProperty(name = "Role1", value = "Role1")
	@JsonProperty("Role1")
	@JacksonXmlProperty(localName = "Role1")
	private String role1;

	@ApiModelProperty(name = "Role2", value = "Role2")
	@JsonProperty("Role2")
	@JacksonXmlProperty(localName = "Role2")
	private String role2;

	@ApiModelProperty(name = "Role3", value = "Role3")
	@JsonProperty("Role3")
	@JacksonXmlProperty(localName = "Role3")
	private String role3;

	@ApiModelProperty(name = "Role4", value = "Role4")
	@JsonProperty("Role4")
	@JacksonXmlProperty(localName = "Role4")
	private String role4;

	@ApiModelProperty(name = "ProfileDescription", value = "ProfileDescription")
	@JsonProperty("ProfileDescription")
	@JacksonXmlProperty(localName = "ProfileDescription")
	private String profileDescription;

	@ApiModelProperty(name = "Active", value = "Active")
	@JsonProperty("Active")
	@JacksonXmlProperty(localName = "Active")
	private int active;

	@ApiModelProperty(name = "sysDate", value = "sysDate")
	@JsonProperty("sysDate")
	@JacksonXmlProperty(localName = "sysDate")
	private Date sysDate;

	@ApiModelProperty(name = "CrBy", value = "CrBy")
	@JsonProperty("CrBy")
	@JacksonXmlProperty(localName = "CrBy")
	private String crBy;
	
	@ApiModelProperty(name = "modDate", value = "modDate")
	@JsonProperty("modDate")
	@JacksonXmlProperty(localName = "modDate")
	private Date modDate;

	@ApiModelProperty(name = "modBy", value = "modBy")
	@JsonProperty("modBy")
	@JacksonXmlProperty(localName = "modBy")
	private String modBy;

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
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return the pClass
	 */
	public String getpClass() {
		return pClass;
	}

	/**
	 * @param pClass the pClass to set
	 */
	public void setpClass(String pClass) {
		this.pClass = pClass;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the role1
	 */
	public String getRole1() {
		return role1;
	}

	/**
	 * @param role1 the role1 to set
	 */
	public void setRole1(String role1) {
		this.role1 = role1;
	}

	/**
	 * @return the role2
	 */
	public String getRole2() {
		return role2;
	}

	/**
	 * @param role2 the role2 to set
	 */
	public void setRole2(String role2) {
		this.role2 = role2;
	}

	/**
	 * @return the role3
	 */
	public String getRole3() {
		return role3;
	}

	/**
	 * @param role3 the role3 to set
	 */
	public void setRole3(String role3) {
		this.role3 = role3;
	}

	/**
	 * @return the role4
	 */
	public String getRole4() {
		return role4;
	}

	/**
	 * @param role4 the role4 to set
	 */
	public void setRole4(String role4) {
		this.role4 = role4;
	}

	/**
	 * @return the profileDescription
	 */
	public String getProfileDescription() {
		return profileDescription;
	}

	/**
	 * @param profileDescription the profileDescription to set
	 */
	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
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
		

}
