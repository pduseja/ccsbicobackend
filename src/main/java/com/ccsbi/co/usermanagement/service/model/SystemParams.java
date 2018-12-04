package com.ccsbi.co.usermanagement.service.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SystemParams implements Serializable {

	private int id;

	private String keyVal1;

	private String keyVal2;

	private String keyVal3;

	private String keyVal4;

	private String keyVal5;

	private String param1;

	private String param2;

	private String param3;

	private String param4;

	private String param5;

	private String insight;

	private Date modDate;

	private String active;	

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
