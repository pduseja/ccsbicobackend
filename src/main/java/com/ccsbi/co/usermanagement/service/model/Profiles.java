package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Profiles implements Serializable{

	private int id;

	private String profile;	

	private String pClass;

	private String template;

	private String role1;

	private String role2;

	private String role3;

	private String role4;

	private String profileDescription;

	private int active;

	private Date sysDate;

	private String crBy;

	private Date modDate;

	private String modBy;

}
