package com.ccsbi.co.common.api.repository.entity;

import java.io.Serializable;
import java.util.Date;

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
	
	@Column(name = "countryname")
	private String countryName;
	
	@Column(name = "countrycode")
	private String countryCode;
	
	@Column(name = "sysdate")
	private Date sysDate;
	
	@Column(name = "active")
	private String active;
}
