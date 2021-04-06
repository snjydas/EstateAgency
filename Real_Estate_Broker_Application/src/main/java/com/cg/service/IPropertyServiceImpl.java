package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.ICustomerRepo;
import com.cg.repository.IDealRepo;
import com.cg.repository.IPropertyRepo;

/******************************************************************************************************************
 *         @author			SANJAY DAS
 *         @Description  	It is a service class that provides methods for performing CRUD operations on Property  
 *         @version        	1.0
 *         @since    		25-MAR-2021
 ******************************************************************************************************************/
@Service
public class IPropertyServiceImpl implements IPropertyService {
	@Autowired
	IPropertyRepo pDao;

	@Autowired
	ICustomerRepo cDao;
	
	@Autowired
	IDealRepo dDao;
	
	/*********************************************************
	 * Method				addProperty
	 * Description			To add new Property to database
	 * @Param property 		New Property object
	 * @returns Property	created Property field in database
	 * Created By 			SANJAY DAS
	 * Created Date			25-MAR-2021
	 ***********************************************************/
	
	@Override
	public Property addProperty(Property property) {
		pDao.saveAndFlush(property);
		return property;
	}
	
	/*********************************************************
	 * Method				editProperty
	 * Description			To update Property in database
	 * @Param property 		Updating Property object
	 * @returns Property	Updated Property field in database
	 * Created By 			SANJAY DAS
	 * Created Date			25-MAR-2021
	 ***********************************************************/

	@Override
	public Property editProperty(Property property) {
		pDao.saveAndFlush(property);
		return pDao.findById(property.getPropId()).get();
	}
	
	/*********************************************************
	 * Method				removeProperty
	 * Description			To delete Property in database
	 * @Param property 		Deleting Property propId
	 * @returns Property	Deleted Property field in database
	 * Created By 			SANJAY DAS
	 * Created Date			25-MAR-2021
	 ***********************************************************/

	@Override
	public Property removeProperty(int propId) throws PropertyNotFoundException {
		Property p=pDao.findById(propId).get();

		
		List<Deal> d= dDao.findAll();
		for(Deal i:d) {
			if(i.getProperty().getPropId()==propId)
				dDao.delete(i);
		}
		
		pDao.deleteById(propId);
		return p;
	}

	/*********************************************************************************
	 * Method				viewProperty
	 * Description			To view Property in database based on supplied Property ID
	 * @Param propId 		Property Id to be viewed
	 * @returns Property	Property record from database with propId
	 * Created By 			SANJAY DAS
	 * Created Date			25-MAR-2021
	 *********************************************************************************/
	
	@Override
	public Property viewProperty(int propId) throws PropertyNotFoundException {
		return pDao.findById(propId).get();
	}

	/**********************************************************
	 * Method				listAllProperties
	 * Description			To view all Properties in database
	 * @returns List		All Properties from the database
	 * Created By 			SANJAY DAS
	 * Created Date			25-MAR-2021
	 ***********************************************************/
	
	@Override
	public List<Property> listAllProperties() {
		return pDao.fetchAllProperties();
	}
	
	/*********************************************************************************
	 * Method				ListPropertyByCriteria
	 * Description			To view Property in database based on supplied criteria
	 * @Param criteria 		Property criteria
	 * @returns List		All properties which are matched with the criteria
	 * Created By 			SANJAY DAS
	 * Created Date			25-MAR-2021
	 *********************************************************************************/

	@Override
	public List<Property> ListPropertyByCriteria(PropertyCriteria criteria) {

		return pDao.fetchPropertyByCriteria(criteria);
	}

}