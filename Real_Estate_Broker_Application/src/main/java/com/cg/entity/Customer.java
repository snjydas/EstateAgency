package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Customer extends User {
	//@GeneratedValue(strategy=GenerationType.AUTO)
			//private int custId;
			private String custName;
			@OneToMany(targetEntity = Property.class,cascade=CascadeType.ALL)
			private List<Property> properties;
			
			public Customer()
			{
				
			}
			
			public Customer(/* int custId, */ String custName, List<Property> properties)
			{
				//this.custId=custId;
				this.custName=custName;
				this.properties=properties;
			}
			/*
			public int getCustId() {
				return custId;
			}

			public void setCustId(int custId) {
				this.custId = custId;
			}*/

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
