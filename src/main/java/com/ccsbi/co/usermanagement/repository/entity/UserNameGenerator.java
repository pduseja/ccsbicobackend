package com.ccsbi.co.usermanagement.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "usernamegenerator")
public class UserNameGenerator implements Serializable {

	@Id
	@Column(name = "id")
	private int Id;
	
	@Column(name="prefix")
	private String prefix;
	
	@Column(name="useridnumber")
	private int userIDNumber;
	
	@Column(name="entityidnumber")
	private String entityIDNumber;

	/**
	 * @return the Id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the Id to set
	 */
	public void setId(int Id) {
		this.Id = Id;
	}
	
	
}
