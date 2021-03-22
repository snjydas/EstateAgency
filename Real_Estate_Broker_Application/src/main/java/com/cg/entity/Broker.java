package com.cg.entity;

import java.util.List;

public class Broker extends User {
	private int broId;
	private String broName;
	private List<Property> properties;
	public String getBroName() {
		return broName;
	}
	public void setBroName(String broName) {
		this.broName = broName;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	
}
