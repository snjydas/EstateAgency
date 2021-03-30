package com.cg.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/***************************************************************************
 * 
 * @author 			
 * Description 		It is an entity class that provides all the fields of User
 * Version			1.0
 * Created Date		30-MAR-2021
 ***************************************************************************/

@Entity
public class Customer extends User {

	private String custName;
	@OneToMany(cascade = CascadeType.ALL)
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
