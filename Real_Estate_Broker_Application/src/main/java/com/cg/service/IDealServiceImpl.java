package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.repository.IDealRepo;

@Service
public class IDealServiceImpl implements IDealService {

	@Autowired
	IDealRepo dealDao;

	@Override
	public Deal addDeal(Deal d) {
		LocalDate today = LocalDate.now();
		return dealDao.saveAndFlush(d);

	}

	@Override
	public List<Deal> listAllDeals() {
		return dealDao.findAll();
	}

}
