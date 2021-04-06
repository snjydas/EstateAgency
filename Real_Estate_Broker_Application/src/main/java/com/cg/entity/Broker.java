package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
/***************************************************************************
 * 
 * @author 			T. CHAITANYA
 * Description 		It is an entity class that provides all the fields of Broker
 * Version			1.0
 * Created Date		23-MAR-2021
 ***************************************************************************/
@Entity
public class Broker extends User {
	private String broName;
	@OneToMany(targetEntity = Property.class, mappedBy = "broker",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Property> properties;
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get name of broker
	 * @returns String	Broker name 
	 * Created By		T. CHAITANYA
	 * Created Date		23-MAR-2021
	 *******************************************/
	public String getBroName() {
		return broName;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set name of broker
	 * @returns void 
	 * Created By		T. CHAITANYA
	 * Created Date		23-MAR-2021
	 *******************************************/
	public void setBroName(String broName) {
		this.broName = broName;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Properties of broker
	 * @returns List	Properties 
	 * Created By		T. CHAITANYA
	 * Created Date		23-MAR-2021
	 *******************************************/
	public List<Property> getProperties() {
		return properties;
	}
	/************************************************************
	 * Method			Setter Method
	 * Description 		To set List of properties field in Broker
	 * @returns void 
	 * Created By		T. CHAITANYA
	 * Created Date		23-MAR-2021
	 ************************************************************/
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
}
