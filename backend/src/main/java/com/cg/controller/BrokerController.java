package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Broker;
import com.cg.entity.Property;
import com.cg.exception.BrokerNotFoundException;
import com.cg.service.IBrokerService;

/***********************************************************************************************
 * @author 			T. CHAITANYA
 * Description		It is a rest controller class that controls the data flow into model object
 					and updates the view whenever data changes
 * @version 		1.0
 * @since		    26-MAR-2021
 ***********************************************************************************************/
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("real-estate-broker-application/broker")
public class BrokerController {
	@Autowired
	IBrokerService bService;
	/********************************************************************************************
	 * Method                          addBroker
     * Description                     It is used to add Broker to Broker entity
     * @param bro:                     Broker's reference variable.
	 * @returns Broker                 Newly created Broker details
	 * @PostMapping:                   Used to handle POST type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      T. CHAITANYA
     * Created Date                    26-MAR-2021                            
	 
	 **********************************************************************************************/
	@PostMapping("/add")
	public Broker addBroker(@RequestBody Broker bro) {

		return bService.addBroker(bro);
	}
	/********************************************************************************************
	 * Method                         	editBroker
     * Description                    	It is used to update Broker in Broker entity
     * @param bro                    	Broker's reference variable.
	 * @returns Broker                 	Updated Broker details
	 * @PutMapping                   	Used to handle PUT type of request method
	 * @RequestBody                   	It maps the HttpRequest body to a transfer or domain object
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
     * Created By                       T. CHAITANYA
     * Created Date                     26-MAR-2021                            
	 
	 **********************************************************************************************/
	@PutMapping("/update")
	public Broker editBroker(@RequestBody Broker bro) throws BrokerNotFoundException {
		try {
			viewBroker(bro.getUserId());
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Given Broker is inappropriate!");
		}
		return bService.editBroker(bro);
	}
	/*************************************************************************************************************************
	 * Method                          	removeBroker
     * Description                     	It is used to delete Broker from Broker entity
     * @param broId                		Broker's reference ID.
	 * @returns Broker                 	Deleted Broker details
	 * @DeleteMapping                 	Used to handle DELETE type of request method
	 * @PathVariable                   	It  is used for data passed in the URI and transfer its values to parameter variables
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
     *Created By                       	T. CHAITANYA
     *Created Date                     	26-MAR-2021                            
	 
	 **************************************************************************************************************************/
	@DeleteMapping("/remove/{broId}")
	public Broker removeBroker(@PathVariable int broId) throws BrokerNotFoundException {
		try {
			viewBroker(broId);
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Broker with given Broker ID not found, Please recheck input!");
		}
		return bService.removeBroker(broId);
	}
	/********************************************************************************************
	 * Method                          	listAllBrokers
     * Description                     	To get all Broker records from Broker entity
	 * @returns List                 	All Broker records
	 * @GetMapping                 		Used to handle GET type of request method
     *Created By                       	T. CHAITANYA
     *Created Date                     	26-MAR-2021                            
	 
	 **********************************************************************************************/
	@GetMapping("/all")
	public List<Broker> listAllBrokers() {
		return bService.listAllBrokers();
	}
	/***********************************************************************************************************************
	 * Method                          	viewBroker
     * Description                     	It is used to get particular Broker from Broker entity
     * @param broId                		Broker's reference ID.
	 * @returns Broker                 	Required Broker details
	 * @GetMapping                 		Used to handle GET type of request method
	 * @PathVariable                   	It  is used for data passed in the URI and transfer its values to parameter variables
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
     *Created By                       	T. CHAITANYA
     *Created Date                     	26-MAR-2021                            
	 
	 ************************************************************************************************************************/
	@GetMapping("/id/{broId}")
	public Broker viewBroker(@PathVariable int broId) throws BrokerNotFoundException {
		try {
			bService.viewBroker(broId);
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Broker with given ID not exists!");
		}
		return bService.viewBroker(broId);
	}
	@GetMapping("/properties/{broId}")
	public List<Property> listAllProperties(@PathVariable int broId){
		return bService.getAllProperties(broId);
	}
}
