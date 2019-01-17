package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "profiles")
public class Profiles implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "profile")
	private String profile;	

	@Column(name = "pclass")
	private String pClass;

	@Column(name = "template")
	private String template;

	@Column(name = "role1")
	private String role1;

	@Column(name = "role2")
	private String role2;

	@Column(name = "role3")
	private String role3;

	@Column(name = "role4")
	private String role4;

	@Column(name = "profiledescription")
	private String profileDescription;

	@Column(name = "active")
	private int active;

	@Column(name = "sysdate")
	private Date sysDate;

	@Column(name = "crby")
	private String crBy;

	@Column(name = "moddate")
	private Date modDate;

	@Column(name = "modby")
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
