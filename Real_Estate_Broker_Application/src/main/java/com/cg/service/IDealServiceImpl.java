package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.repository.IDealRepo;

public class IDealServiceImpl implements IDealService {

	@Autowired
	IDealRepo dealDao;

	@Override
	public Deal addDeal(Property property, Customer customer) {
		LocalDate today = LocalDate.now();
		return dealDao.saveAndFlush(new Deal(today, property.getOfferCost(), customer, property));

	}

	@Override
	public List<Deal> listAllDeals() {
		return dealDao.findAll();
	}

}
