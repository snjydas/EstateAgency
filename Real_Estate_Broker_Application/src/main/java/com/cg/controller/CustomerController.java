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

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.service.ICustomerService;


/***********************************************************************************************
 * 
 * @author 			ROOSA MOZOOMDAR
 * Description		It is a rest controller class that controls the data flow into model object
 					and updates the view whenever data changes
 * Version 			1.0
 * @since			26-MAR-2021
 ************************************************************************************************/
@RestController
@RequestMapping("real-estate-broker-application/customer")
public class CustomerController {

	@Autowired
	ICustomerService cService;
	/**********************************************************************************************
	 * Method                          addCustomer
     * Description                     It is used to add Customer to Customer entity
     * @param cust:                    Customer's reference variable.
	 * @returns Customer               Newly created Customer details
	 * @PostMapping:                   Used to handle POST type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      ROOSA MOZOOMDAR
     * Created Date                    26-MAR-2021                            
	 **********************************************************************************************/
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer cust) {
		return cService.addCustomer(cust);
	}
	/********************************************************************************************
	 * Method                          editCustomer
     * Description                     It is used to update Customer in Customer entity
     * @param cust:                    Customer's reference variable.
	 * @returns Customer               Updated Customer details
	 * @PutMapping:                    Used to handle PUT type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      ROOSA MOZOOMDAR
     * Created Date                    26-MAR-2021                            
	 **********************************************************************************************/

	@PutMapping("/update")
	public Customer editCustomer(@RequestBody Customer cust) throws CustomerNotFoundException{
		try {
			viewCustomer(cust.getUserId());
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("Given Customer is inapproproate");
		}
		
		return cService.editCustomer(cust);
	}
	
	/*************************************************************************************************************************
	 * Method                            removeCustomer
     * Description                       It is used to delete Customer from Customer entity
     * @param custId:                    Customer's reference Id.
	 * @returns Customer                 Deleted Customer details
	 * @DeleteMapping                 	 Used to handle DELETE type of request method
	 * @PathVariable                   	 It  is used for data passed in the URI and transfer its values to parameter variables
	 * @throws CustomerNotFoundException It is raised due to invalid Customer ID
     * Created By                        ROOSA MOZOOMDAR
     * Created Date                      26-MAR-2021                            
	 **************************************************************************************************************************/

	@DeleteMapping("/remove/{custId}")
	public Customer removeCustomer(@PathVariable int custId) throws CustomerNotFoundException {

		try {
			return cService.removeCustomer(custId);
		} catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException("The entered custId is not found! Enter a valid custId to delete.");
		}
	}
	
	/********************************************************************************************************
	 * Method                          viewCustomer
     * Description                     It is used to get the Customer from Customer entity with particular Id
     * @param custId:                  Customer's reference Id.
	 * @returns Customer               Customer Customer details with required Id
	 * @GetMapping                 	   Used to handle GET type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      ROOSA MOZOOMDAR
     * Created Date                    26-MAR-2021                            
	 *********************************************************************************************************/

	@GetMapping("/id/{custId}")
	public Customer viewCustomer(@PathVariable int custId) throws CustomerNotFoundException {
		try {
			return cService.viewCustomer(custId);
		} catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException("The entered custId is not found! Enter a valid custId to find.");
		}
	}
	
	/********************************************************************************************************
	 * Method                          listAllCustomers
     * Description                     It is used to get all Customers from Customer entity
	 * @returns Customer               Customer Customer details with required Id
	 * @GetMapping                 	   Used to handle GET type of request method
     * Created By                      ROOSA MOZOOMDAR
     * Created Date                    26-MAR-2021                            
	 *********************************************************************************************************/
	
	@GetMapping("/all")
	public List<Customer> listAllCustomers() {
		return cService.listAllCustomers();
	}

}
