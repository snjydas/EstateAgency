package com.cg.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/***************************************************************************
 * 
 * @author 			Roosa Mazoomdar
 * Description 		It is an entity class that provides all the fields of User
 * @version			1.0
 * @since			22-MAR-2021
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
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get name of Customer
	 * @returns String	Customer name 
	 * Created By		Roosa Mazoomdar
	 * Created Date		22-MAR-2021
	 *******************************************/
	public String getCustName() {
		return custName;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set name of Customer
	 * @param custName  Customer Name
	 * @returns void
	 * Created By		Roosa Mazoomdar
	 * Created Date		22-MAR-2021
	 *******************************************/
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get all Customers
	 * @returns List	list of all Properties
	 * Created By		Roosa Mazoomdar
	 * Created Date		22-MAR-2021
	 *******************************************/
	public List<Property> getProperties() {
		return properties;
	}
	/*******************************************
	 * Method			 Setter Method
	 * Description 		 To set name of Customer
	 * @param properties List of all properties
	 * @returns void
	 * Created By		 Roosa Mazoomdar
	 * Created Date		 22-MAR-2021
	 *******************************************/
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
