package com.cg.dao;

import java.util.List;

import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;

public interface PropertyDao {

	public List<Property> fetchAllProperties();

	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria);
}
