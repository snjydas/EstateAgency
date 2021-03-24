package com.cg.entity;

import java.util.List;

import javax.persistence.Id;

public class Customer extends User {
	@Id
	private int custId;
	private String custName;
	private List<Property> properties;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String userid, String password, String role, String mobile, String email, String city) {
		super(userid, password, role, mobile, email, city);
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String custName, List<Property> properties) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.properties = properties;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
