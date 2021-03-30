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
 * @author 			
 * Description 		It is an entity class that provides all the fields of User
 * Version			1.0
 * Created Date		30-MAR-2021
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

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public LocalDate getDealDate() {
		return dealDate;
	}

	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
	}

	public double getDealCost() {
		return dealCost;
	}

	public void setDealCost(double dealCost) {
		this.dealCost = dealCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}
