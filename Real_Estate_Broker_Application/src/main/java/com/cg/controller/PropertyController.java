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

@RestController
@RequestMapping("real-estate-broker-application/property")
public class PropertyController {

	@Autowired
	IPropertyService propertyService;

	@PostMapping(value = "/add")
	public Property addProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}

	@PutMapping(value = "/update")
	public Property updatePropertyData(@RequestBody Property property) {
		return propertyService.editProperty(property);

	}

	@DeleteMapping("/remove/{propId}")
	public Property deleteProperty(@PathVariable int propId) throws PropertyNotFoundException  {
		Property p = null;
		try {
			p = propertyService.removeProperty(propId);
		} catch (Exception e) {
			throw new PropertyNotFoundException("The entered propID is not found! Enter a valid propID to delete.");
		}
		return p;
	}

	@GetMapping("/id/{propId}")
	public Property findPropertyById(@PathVariable int propId) throws PropertyNotFoundException {
		Property p = null;
		try {
			p = propertyService.viewProperty(propId);
		} catch (Exception e) {
			throw new PropertyNotFoundException("The entered propID is not found! Enter a valid propIDb to find.");
		}
		return p;
	}

	@GetMapping("/all")
	public List<Property> printAllProperties() {
		return propertyService.listAllProperties();
	}

	@GetMapping("criteria/{criteria}")
	public List<Property> listPropertyByCriteria(@PathVariable PropertyCriteria criteria) {
		return propertyService.ListPropertyByCriteria(criteria);
	}

}