package com.cg.service;

import java.util.List;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
/*************************************************************************************************************
 * @author 		SANJAY DAS
 * Description	It is an interface of service layer of property module that provides various methods for its implementation class
 * @version		1.0
 * @since		23-MAR-2021 
 **************************************************************************************************************/

public interface IPropertyService {

	public Property addProperty(Property property);

	public Property editProperty(Property property);

	public Property removeProperty(int propId) throws PropertyNotFoundException;

	public Property viewProperty(int propId) throws PropertyNotFoundException;

	public List<Property> listAllProperties();

	public List<Property> ListPropertyByCriteria(PropertyCriteria criteria);

}
