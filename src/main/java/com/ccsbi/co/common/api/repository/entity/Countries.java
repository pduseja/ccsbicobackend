package com.ccsbi.co.common.api.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "countries")
public class Countries implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "sortname")
	private String sortname;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phonecode")
	private int phonecode;

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
	 * @return the sortname
	 */
	public String getSortname() {
		return sortname;
	}

	/**
	 * @param sortname the sortname to set
	 */
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phonecode
	 */
	public int getPhonecode() {
		return phonecode;
	}

	/**
	 * @param phonecode the phonecode to set
	 */
	public void setPhonecode(int phonecode) {
		this.phonecode = phonecode;
	}
	
	
}
