package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.repository.ICustomerRepo;
import com.cg.repository.IDealRepo;
import com.cg.repository.IPropertyRepo;

@Service
public class IDealServiceImpl implements IDealService {

	@Autowired
	IDealRepo dealDao;
	@Autowired
	ICustomerRepo cDao;
	@Autowired
	IPropertyRepo pDao;

	@Override
	public Deal addDeal(Deal d) {
		Property p1=pDao.findById(d.getProperty().getPropId()).get();
		Customer c=cDao.findById(d.getCustomer().getUserId()).get(); 
		p1.setStatus(false);
		pDao.saveAndFlush(p1);
		List<Property> p= c.getProperties();
		p.add(p1);
		c.setProperties(p);
		cDao.saveAndFlush(c);
		return dealDao.saveAndFlush(d);

	}

	@Override
	public List<Deal> listAllDeals() {
		return dealDao.findAll();
	}

}
