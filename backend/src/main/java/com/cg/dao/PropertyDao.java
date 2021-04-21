package com.cg.dao;

import java.util.List;

import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;
/********************************************************************************************************
 * @author 		SANJAY DAS
 * Description	It is an interface of service layer that provides various methods for its implementation class
 * @version		1.0
 * @since	24-MAR-2021 
 ********************************************************************************************************/
public interface PropertyDao {


	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria);
}
