package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.IPropertyRepo;

@Service
public class IPropertyServiceImpl implements IPropertyService {
	@Autowired
	IPropertyRepo pDao;

	@Override
	public Property addProperty(Property property) {
		pDao.saveAndFlush(property);
		return property;
	}

	@Override
	public Property editProperty(Property property) {
		pDao.saveAndFlush(property);
		return property;
	}

	@Override
	public Property removeProperty(int propId) throws PropertyNotFoundException {
		Property p = pDao.findById(propId).get();
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