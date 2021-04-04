package com.cg.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
/***************************************************************************
 * 
 * @author 			PATHAN ARSHIYA SHAHINA
 * Description 		It is an entity class that provides all the fields of Deals
 * @version			1.0
 * @since			23-MAR-2021
 ***************************************************************************/


@Entity

public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dealId;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dealDate;
	private double dealCost;
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "user_id")
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "property_id", referencedColumnName = "propId")
	private Property property;

	public Deal() {

	}

	public Deal(LocalDate dealDate, double dealCost, Customer customer, Property property) {
		super();

		this.dealDate = dealDate;
		this.dealCost = dealCost;
		this.customer = customer;
		this.property = property;
	}

	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Id of deal
	 * @returns int     Deal Id 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public int getDealId() {
		return dealId;
	}

	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Id of deal
	 * @param dealId	Deal Id
	 * @returns void 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	
	/**********************************************
	 * Method				Getter Method
	 * Description 			To get date of deal
	 * @returns LocalDate   Deal date 
	 * Created By			PATHAN ARSHIYA SHAHINA
	 * Created Date			23-MAR-2021
	 **********************************************/

	public LocalDate getDealDate() {
		return dealDate;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set date of deal
	 * @param dealDate	Deal date
	 * @returns void 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
	}

	/*******************************************
	 * Method			Getter Method
	 * Description 		To get cost of deal
	 * @returns double  Deal cost 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/
	
	public double getDealCost() {
		return dealCost;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set cost of deal
	 * @param dealCost	Deal cost
	 * @returns void 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setDealCost(double dealCost) {
		this.dealCost = dealCost;
	}

	/**********************************************
	 * Method				Getter Method
	 * Description 			To get Customer of deal
	 * @returns Customer    Deal Customer 
	 * Created By			PATHAN ARSHIYA SHAHINA
	 * Created Date			23-MAR-2021
	 ***********************************************/
	
	public Customer getCustomer() {
		return customer;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Customer of deal
	 * @param customer	Deal Customer
	 * @returns void 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**********************************************
	 * Method				Getter Method
	 * Description 			To get property of deal
	 * @returns Property    Deal property 
	 * Created By			PATHAN ARSHIYA SHAHINA
	 * Created Date			23-MAR-2021
	 ***********************************************/

	public Property getProperty() {
		return property;
	}
	
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Property of deal
	 * @param property	Deal property
	 * @returns void 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		23-MAR-2021
	 *******************************************/

	public void setProperty(Property property) {
		this.property = property;
	}

}
