package com.ccsbi.co.usermanagement.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "SystemParams")
@JacksonXmlRootElement(localName = "SystemParams")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class SystemParams implements Serializable {
	
	@ApiModelProperty(name = "id", required = true, readOnly = true, value = "The system params ID")
	@JsonProperty("id")
	@JacksonXmlProperty(localName = "id")
	private int id;
	
	@ApiModelProperty(name = "keyVal1", value = "keyVal1")
	@JsonProperty("keyVal1")
	@JacksonXmlProperty(localName = "keyVal1")
	private String keyVal1;
	
	@ApiModelProperty(name = "keyVal2", value = "keyVal2")
	@JsonProperty("keyVal2")
	@JacksonXmlProperty(localName = "keyVal2")
	private String keyVal2;
	
	@ApiModelProperty(name = "keyVal3", value = "keyVal3")
	@JsonProperty("keyVal3")
	@JacksonXmlProperty(localName = "keyVal3")
	private String keyVal3;
	
	@ApiModelProperty(name = "keyVal4", value = "keyVal4")
	@JsonProperty("keyVal4")
	@JacksonXmlProperty(localName = "keyVal4")
	private String keyVal4;
	
	@ApiModelProperty(name = "keyVal5", value = "keyVal5")
	@JsonProperty("keyVal5")
	@JacksonXmlProperty(localName = "keyVal5")
	private String keyVal5;
	
	@ApiModelProperty(name = "param1", value = "param1")
	@JsonProperty("param1")
	@JacksonXmlProperty(localName = "param1")
	private String param1;
	
	@ApiModelProperty(name = "param2", value = "param2")
	@JsonProperty("param2")
	@JacksonXmlProperty(localName = "param2")
	private String param2;
	
	@ApiModelProperty(name = "param3", value = "param3")
	@JsonProperty("param3")
	@JacksonXmlProperty(localName = "param3")
	private String param3;
	
	@ApiModelProperty(name = "param4", value = "param4")
	@JsonProperty("param4")
	@JacksonXmlProperty(localName = "param4")
	private String param4;
	
	@ApiModelProperty(name = "param5", value = "param5")
	@JsonProperty("param5")
	@JacksonXmlProperty(localName = "param5")
	private String param5;
	
	@ApiModelProperty(name = "insight", value = "insight")
	@JsonProperty("insight")
	@JacksonXmlProperty(localName = "insight")
	private String insight;
	
	@ApiModelProperty(name = "modDate", value = "modDate")
	@JsonProperty("modDate")
	@JacksonXmlProperty(localName = "modDate")
	private Date modDate;
	
	@ApiModelProperty(name = "active", value = "active")
	@JsonProperty("active")
	@JacksonXmlProperty(localName = "active")
	private String active;
	
	@ApiModelProperty(name = "columnOrderBy", value = "columnOrderBy")
	@JsonProperty("columnOrderBy")
	@JacksonXmlProperty(localName = "columnOrderBy")
	private int columnOrderBy;

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
	 * @return the keyVal1
	 */
	public String getKeyVal1() {
		return keyVal1;
	}

	/**
	 * @param keyVal1 the keyVal1 to set
	 */
	public void setKeyVal1(String keyVal1) {
		this.keyVal1 = keyVal1;
	}

	/**
	 * @return the keyVal2
	 */
	public String getKeyVal2() {
		return keyVal2;
	}

	/**
	 * @param keyVal2 the keyVal2 to set
	 */
	public void setKeyVal2(String keyVal2) {
		this.keyVal2 = keyVal2;
	}

	/**
	 * @return the keyVal3
	 */
	public String getKeyVal3() {
		return keyVal3;
	}

	/**
	 * @param keyVal3 the keyVal3 to set
	 */
	public void setKeyVal3(String keyVal3) {
		this.keyVal3 = keyVal3;
	}

	/**
	 * @return the keyVal4
	 */
	public String getKeyVal4() {
		return keyVal4;
	}

	/**
	 * @param keyVal4 the keyVal4 to set
	 */
	public void setKeyVal4(String keyVal4) {
		this.keyVal4 = keyVal4;
	}

	/**
	 * @return the keyVal5
	 */
	public String getKeyVal5() {
		return keyVal5;
	}

	/**
	 * @param keyVal5 the keyVal5 to set
	 */
	public void setKeyVal5(String keyVal5) {
		this.keyVal5 = keyVal5;
	}

	/**
	 * @return the param1
	 */
	public String getParam1() {
		return param1;
	}

	/**
	 * @param param1 the param1 to set
	 */
	public void setParam1(String param1) {
		this.param1 = param1;
	}

	/**
	 * @return the param2
	 */
	public String getParam2() {
		return param2;
	}

	/**
	 * @param param2 the param2 to set
	 */
	public void setParam2(String param2) {
		this.param2 = param2;
	}

	/**
	 * @return the param3
	 */
	public String getParam3() {
		return param3;
	}

	/**
	 * @param param3 the param3 to set
	 */
	public void setParam3(String param3) {
		this.param3 = param3;
	}

	/**
	 * @return the param4
	 */
	public String getParam4() {
		return param4;
	}

	/**
	 * @param param4 the param4 to set
	 */
	public void setParam4(String param4) {
		this.param4 = param4;
	}

	/**
	 * @return the param5
	 */
	public String getParam5() {
		return param5;
	}

	/**
	 * @param param5 the param5 to set
	 */
	public void setParam5(String param5) {
		this.param5 = param5;
	}

	/**
	 * @return the insight
	 */
	public String getInsight() {
		return insight;
	}

	/**
	 * @param insight the insight to set
	 */
	public void setInsight(String insight) {
		this.insight = insight;
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
	 * @return the columnOrderBy
	 */
	public int getColumnOrderBy() {
		return columnOrderBy;
	}

	/**
	 * @param columnOrderBy the columnOrderBy to set
	 */
	public void setColumnOrderBy(int columnOrderBy) {
		this.columnOrderBy = columnOrderBy;
	}

}
