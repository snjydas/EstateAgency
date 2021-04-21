package com.cg.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/***************************************************************************
 * 
 * @author 			SANJAY DAS
 * Description 		It is an entity class that provides all the fields of Property
 * @version			1.0
 * @since   		23-MAR-2021
 * 
 ***************************************************************************/

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propId;
	private String configuration; // Flat/Shop/Plot
	private String offerType; // Sell/Rent
	private double offerCost;
	private double areaSqft;
	private String city;
	private String address;
	private String street;
	private boolean status; // Available(true)/ Sold(false)
	@ManyToOne(targetEntity = Broker.class)
	@JoinColumn(name = "Broker", referencedColumnName = "user_Id")

	private Broker broker;

	public Property(int propId, String configuration, String offerType, double offerCost, double areaSqft, String city,
			String address, String street, boolean status, Broker broker) {
		super();
		this.propId = propId;
		this.configuration = configuration;
		this.offerType = offerType;
		this.offerCost = offerCost;
		this.areaSqft = areaSqft;
		this.city = city;
		this.address = address;
		this.street = street;
		this.status = status;
		this.broker = broker;
	}

	public Property() {

	}

	@Override
	public String toString() {
		return "Property [propId=" + propId + ", configuration=" + configuration + ", offerType=" + offerType
				+ ", offerCost=" + offerCost + ", areaSqft=" + areaSqft + ", city=" + city + ", address=" + address
				+ ", street=" + street + ", status=" + status + ", broker=" + broker + "]";
	}

	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Id of Property
	 * @returns int 	Property Id 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public int getPropId() {
		return propId;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Id of Property
	 * @param propId	Property Id
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setPropId(int propId) {
		this.propId = propId;
	}

	/***************************************************
	 * Method			Getter Method
	 * Description 		To get configuration of Property
	 * @returns String 	Property configuration
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 ***************************************************/
	
	public String getConfiguration() {
		return configuration;
	}
	
	/*********************************************************
	 * Method				 Setter Method
	 * Description 			 To set configuration of Property
	 * @param configuration	 Property configuration
	 * @returns void 
	 * Created By			 SANJAY DAS
	 * Created Date			 23-MAR-2021
	 **********************************************************/

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	/************************************************
	 * Method			Getter Method
	 * Description 		To get offer type of Property
	 * @returns String 	Property offer type
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 ************************************************/
	
	public String getOfferType() {
		return offerType;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set offer type of Property
	 * @param offerType	Property offer type
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	/*******************************************
	 * Method			Getter Method
	 * Description 		To get offer cost of Property
	 * @returns double 	Property offer cost
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public double getOfferCost() {
		return offerCost;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set offer cost of Property
	 * @param offerCost	Property offer cost
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setOfferCost(double offerCost) {
		this.offerCost = offerCost;
	}
	
	/***********************************************
	 * Method			Getter Method
	 * Description 		To get area of Property
	 * @returns double 	Property area in square feet
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 ***********************************************/

	public double getAreaSqft() {
		return areaSqft;
	}
	
	/************************************************
	 * Method			Setter Method
	 * Description 		To set area of Property
	 * @param propId	Property area in square feet
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *************************************************/

	public void setAreaSqft(double areaSqft) {
		this.areaSqft = areaSqft;
	}
	
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get city of Property
	 * @returns String 	Property city 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public String getCity() {
		return city;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set city of Property
	 * @param propId	Property city
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setCity(String city) {
		this.city = city;
	}
	
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get address of Property
	 * @returns String 	Property address
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public String getAddress() {
		return address;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set address of Property
	 * @param propId	Property address
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setAddress(String address) {
		this.address = address;
	}
	
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get street of Property
	 * @returns String 	Property Street 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public String getStreet() {
		return street;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set street of Property
	 * @param street	Property street
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setStreet(String street) {
		this.street = street;
	}

	/*******************************************
	 * Method			Getter Method
	 * Description 		To get status of Property
	 * @returns boolean Property Status 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public boolean getStatus() {
		return status;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set status of Property
	 * @param status	Property status
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setStatus(boolean status) {
		this.status = status;
	}

	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Broker of Property
	 * @returns Broker  Property broker
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public Broker getBroker() {
		return broker;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Broker of Property
	 * @param broker	Broker of the property
	 * @returns void 
	 * Created By		SANJAY DAS
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

}
