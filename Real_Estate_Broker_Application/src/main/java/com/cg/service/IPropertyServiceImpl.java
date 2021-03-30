package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.ICustomerRepo;
import com.cg.repository.IDealRepo;
import com.cg.repository.IPropertyRepo;

@Service
public class IPropertyServiceImpl implements IPropertyService {
	@Autowired
	IPropertyRepo pDao;

	@Autowired
	ICustomerRepo cDao;
	
	@Autowired
	IDealRepo dDao;
	
	@Override
	public Property addProperty(Property property) {
		pDao.saveAndFlush(property);
		return property;
	}

	@Override
	public Property editProperty(Property property) {
		pDao.saveAndFlush(property);
		return pDao.findById(property.getPropId()).get();
	}

	@Override
	public Property removeProperty(int propId) throws PropertyNotFoundException {
		Property p=pDao.findById(propId).get();
//		List<Customer> l= cDao.findAll();
//		for(Customer c:l) {
//			List<Property> lp=c.getProperties();
//			lp.remove(p);
//			c.setProperties(lp);
//			cDao.saveAndFlush(c);
//		}
		
		List<Deal> d= dDao.findAll();
		for(Deal i:d) {
			if(i.getProperty().getPropId()==propId)
				dDao.delete(i);
		}
		
		pDao.deleteById(propId);
		return p;
	}

	@Override
	public Property viewProperty(int propId) throws PropertyNotFoundException {
		return pDao.findById(propId).get();
	}

	@Override
	public List<Property> listAllProperties() {
		return pDao.fetchAllProperties();
	}

	@Override
	public List<Property> ListPropertyByCriteria(PropertyCriteria criteria) {

		return pDao.fetchPropertyByCriteria(criteria);
	}

}