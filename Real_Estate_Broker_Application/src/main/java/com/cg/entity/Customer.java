package com.cg.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

	private String custName;
	@OneToMany
	@JoinColumn(name = "custId")
	private List<Property> properties;

	public Customer() {

	}

	public Customer(String custName, List<Property> properties) {
		this.custName = custName;
		this.properties = properties;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
