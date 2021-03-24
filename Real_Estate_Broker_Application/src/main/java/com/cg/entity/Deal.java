package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dealId;
	private LocalDate dealDate;
	private double dealCost;
	private Customer customer;
@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name="customer_FK")

	private Property property;

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
