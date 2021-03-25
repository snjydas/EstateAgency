package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{

		private String custName;
		@OneToMany
		@JoinColumn(name="cust_id")
		private List<Property> properties;
		
		public Customer()
		{
			
		}
		
		public Customer(String custName, List<Property> properties)
		{
			this.custName=custName;
			this.properties=properties;
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
