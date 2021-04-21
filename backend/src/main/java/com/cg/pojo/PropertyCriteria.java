package com.cg.pojo;
/*****************************************************************************************
 * @author 			RAKSHITH VUPPALA
 * Description 		It is an POJO class that provides all the fields of Property Criteria
 * Version			1.0
 * Created Date		23-MAR-2021
 ******************************************************************************************/

public class PropertyCriteria {
	private String config; // Flat/Shop/Plot
	private String offer; // Sale/Rent
	private String city; // Not specified then all
	private double minCost; // Not specified then 0
	private double maxCost; // Not specified then max double value

	public PropertyCriteria() {

	}

	public PropertyCriteria(String config, String offer, String city, double minCost, double maxCost) {
		super();
		this.config = config;
		this.offer = offer;
		this.city = city;
		this.minCost = minCost;
		this.maxCost = maxCost;
	}
	/***************************************************************
	 * Method			Getter Method
	 * Description 		To get Configuration of the property criteria
	 * @returns String  PropertyCriteria Configuration
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 ***************************************************************/
	public String getConfig() {
		return config;
	}
	/****************************************************************
	 * Method			Setter Method
	 * Description 		To set Configuration of the property criteria
	 * @returns void
	 * @param String    config
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 ****************************************************************/
	public void setConfig(String config) {
		this.config = config;
	}
	/*******************************************************
	 * Method			Getter Method
	 * Description 		To get Offer of the property criteria
	 * @returns String  PropertyCriteria Offer
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 *******************************************************/
	public String getOffer() {
		return offer;
	}
	/*********************************************************
	 * Method			Setter Method
	 * Description 		To set Offer of the property criteria
	 * @returns void
	 * @param String    offer
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 *********************************************************/
	public void setOffer(String offer) {
		this.offer = offer;
	}
	/*******************************************************
	 * Method			Getter Method
	 * Description 		To get city of the property criteria
	 * @returns String  PropertyCriteria city
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 *******************************************************/
	public String getCity() {
		return city;
	}
	/********************************************************
	 * Method			Setter Method
	 * Description 		To set city of the property criteria
	 * @returns void
	 * @param String 	city
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 ********************************************************/
	public void setCity(String city) {
		this.city = city;
	}
	/**************************************************************
	 * Method			Getter Method
	 * Description 		To get minimum cost of the property criteria
	 * @returns double  PropertyCriteria minCost
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 *************************************************************/
	public double getMinCost() {
		return minCost;
	}
	/**********************************************************
	 * Method			Setter Method
	 * Description 		To set minCost of the property criteria
	 * @returns void
	 * @param double 	minCost
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 **********************************************************/
	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}
	/***********************************************************
	 * Method			Getter Method
	 * Description 		To get maxCost of the property criteria
	 * @returns double  PropertyCriteria maxCost
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 ************************************************************/
	public double getMaxCost() {
		return maxCost;
	}
	/***********************************************************
	 * Method			Setter Method
	 * Description 		To set maxCost of the property criteria
	 * @returns void
	 * @param double 	maxCost
	 * Created By		RAKSHITH VUPPALA
	 * Created Date		23-MAR-2021
	 ***********************************************************/
	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}

}
