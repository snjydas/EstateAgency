package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.service.IPropertyService;
/***********************************************************************************************
 * 
 * @author 			SANJAY DAS
 * Description		It is a rest controller class that controls the data flow into model object
 					and updates the view whenever data changes
 * @version 		1.0
 * @since			26-MAR-2021
 ***********************************************************************************************/
@RestController
@RequestMapping("/real-estate-broker-application/property")
public class PropertyController {

	@Autowired
	IPropertyService propertyService;

	/********************************************************************************************
	 * Method                          addProperty
     * Description                     It is used to add Property to Property entity
     * @param property:                Property's reference variable.
	 * @returns Property               Newly created Property details
	 * @PostMapping:                   Used to handle POST type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      SANJAY DAS
     * Created Date                    26-MAR-2021                            
	 
	 **********************************************************************************************/
	
	@PostMapping(value = "/add")
	public Property addProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}
	
	/********************************************************************************************
	 * Method                         	updatePropertyData
     * Description                    	It is used to update property in Property entity
     * @param property                  Property reference variable.
	 * @returns Property                Updated Property details
	 * @PutMapping                   	Used to handle PUT type of request method
	 * @RequestBody                   	It maps the HttpRequest body to a transfer or domain object
     * Created By                       SANJAY DAS
     * Created Date                     26-MAR-2021                            
	 
	 **********************************************************************************************/

	@PutMapping(value = "/update")
	public Property updatePropertyData(@RequestBody Property property) throws PropertyNotFoundException {
		try {
			propertyService.viewProperty(property.getPropId());
		}
		catch(Exception e) {
			throw new PropertyNotFoundException("The property does not exists");
		}
		return propertyService.editProperty(property);

	}
	
	/*************************************************************************************************************************
	 * Method                          		deleteProperty
     * Description                     		It is used to delete Broker from Property entity
     * @param propId               			Property's reference ID.
	 * @returns Property                	Deleted Property details
	 * @DeleteMapping                 		Used to handle DELETE type of request method
	 * @PathVariable                   		It  is used for data passed in the URI and transfer its values to parameter variables
	 * @throws PropertyNotFoundException	It is raised due to invalid Broker ID
     *Created By                       		SANJAY DAS
     *Created Date                     		26-MAR-2021                            
	 
	 **************************************************************************************************************************/

	@DeleteMapping("/remove/{propId}")
	public Property deleteProperty(@PathVariable int propId) throws PropertyNotFoundException {
		Property p = null;
		try {
			p = propertyService.removeProperty(propId);
		} catch (Exception e) {
			throw new PropertyNotFoundException("The entered propId is not found! Enter a valid propId to delete.");
		}
		return p;
	}

	/*****************************************************************************************************************************
	 * Method                          		findPropertyById
     * Description                     		It is used to get particular Property from Property entity
     * @param propId               			Proprty's reference ID.
	 * @returns Property               		Required Property details
	 * @GetMapping                 			Used to handle GET type of request method
	 * @PathVariable                   		It  is used for data passed in the URI and transfer its values to parameter variables
	 * @throws PropertyNotFoundException	It is raised due to invalid Broker ID
     *Created By                       		SANJAY DAS
     *Created Date                     		26-MAR-2021                            
	 
	 ****************************************************************************************************************************/
	
	@GetMapping("/id/{propId}")
	public Property findPropertyById(@PathVariable int propId) throws PropertyNotFoundException {
		Property p = null;
		try {
			p = propertyService.viewProperty(propId);
		} catch (Exception e) {
			throw new PropertyNotFoundException("The entered propId is not found! Enter a valid propId to find.");
		}
		return p;
	}

	/********************************************************************************************
	 * Method                          	printAllProperties
     * Description                     	To get all Property records from Proerty entity
	 * @returns List                 	All Property records
	 * @GetMapping                 		Used to handle GET type of request method
     *Created By                       	SANJAY DAS
     *Created Date                     	26-MAR-2021                            
	 
	 **********************************************************************************************/
	
	@GetMapping("/all")
	public List<Property> printAllProperties() {
		return propertyService.listAllProperties();
	}

	/********************************************************************************************
	 * Method                          listPropertyByCriteria
     * Description                     It is used to get all Properties with given criteria from Property entity
     * @param criteria:                Property criteria reference variable.
	 * @returns List 	               All Property details which satisfies the criteria
	 * @PostMapping:                   Used to handle POST type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      SANJAY DAS
     * Created Date                    26-MAR-2021                            
	 
	 **********************************************************************************************/
	
	@PostMapping("/criteria")
	public List<Property> listPropertyByCriteria(@RequestBody PropertyCriteria criteria) {
		return propertyService.ListPropertyByCriteria(criteria);
	}

}