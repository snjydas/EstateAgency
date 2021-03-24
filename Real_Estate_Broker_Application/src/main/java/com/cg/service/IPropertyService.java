package com.cg.service;

import java.util.List;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;

public interface IPropertyService {

	public Property addProperty(Property property);

	public Property editProperty(Property property);

	public Property removeProperty(int propId) throws PropertyNotFoundException;

	public Property viewProperty(int propId) throws PropertyNotFoundException;

	public List<Property> listAllProperties();

	public List<Property> ListPropertyByCriteria(PropertyCriteria criteria);

}
