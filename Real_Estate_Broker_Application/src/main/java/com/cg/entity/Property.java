package com.cg.entity;

public class Property {
	private int propId;
	private String configuration;	// Flat/Shop/Plot
	private String offerType;	// Sell/Rent
	private double offerCost;
	private double areaSqft;
	private String city;
	private String address;
	private String street;
	private boolean status;	// Available(true)/ Sold(false)
	private Broker broker;
}
