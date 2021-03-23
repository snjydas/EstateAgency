package com.cg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/property")
public class PropertyController {
	
		@Autowired
		IPropertyService propertyService;
		
		@GetMapping
		public List<Property> printAllProperties(){
			return  propertyService.listAllProperties();	
		}
		
		
		@GetMapping("/{propId}") 
		  public Property findPropertyById(@PathVariable int propId)throws PropertyNotFoundException{
			  Property p=null;
			  try {
				  p=propertyService.viewProperty(propId);
			  }
				catch(Exception e) {
					throw new PropertyNotFoundException();
				}
				return p;
		  }
		
		
		@PostMapping(value = "/create")
		public  List<Property> addProperty(@RequestBody Property property) {
			return (List<Property>) propertyService.addProperty(property);
		}
		
		
		@DeleteMapping("{propId}")
		public List<Property> removePropertyData(@PathVariable int propId) throws PropertyNotFoundException{
			return  (List<Property>) propertyService.removeProperty(propId);
		}
		
		@PutMapping(value="/update")
		public List<Property> updateTraineeData(@RequestBody Property property){
			return  (List<Property>) propertyService.editProperty(property);
			
		}
		
		@GetMapping("name/{traineeName}")
		public List<Property> listPropertyByCriteria(@PathVariable PropertyCriteria criteria) {
			return propertyService.listPropertyByCriteria(criteria);
		}
		
}