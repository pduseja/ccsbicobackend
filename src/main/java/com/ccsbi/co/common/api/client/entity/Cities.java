package com.ccsbi.co.common.api.client.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Cities")
@JacksonXmlRootElement(localName = "Cities")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class Cities implements Serializable{
	
	@ApiModelProperty(name = "id", required = true, readOnly = true, value = "The Address ID")
	@JsonProperty("id")
	@JacksonXmlProperty(localName = "id")
	private int id;

	@ApiModelProperty(name = "name", value = "name")
	@JsonProperty("name")
	@JacksonXmlProperty(localName = "name")
	private String name;
	
	@ApiModelProperty(name = "stateId", value = "stateId")
	@JsonProperty("stateId")
	@JacksonXmlProperty(localName = "stateId")
	private int stateId;

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
	 * @return the stateId
	 */
	public int getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

}
