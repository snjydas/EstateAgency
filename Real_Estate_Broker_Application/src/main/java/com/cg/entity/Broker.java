package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Broker extends User {
	private String broName;
	@OneToMany(targetEntity = Property.class, mappedBy = "broker",cascade = CascadeType.ALL)
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
