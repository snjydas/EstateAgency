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

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService cService;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer c) {
		return cService.addCustomer(c);
	}

	@PutMapping("/update")
	public Customer editCustomer(@RequestBody Customer c) {
		return cService.editCustomer(c);
	}

	@DeleteMapping("/id/{custId}")
	public Customer removeCustomer(@PathVariable int custId) throws CustomerNotFoundException {

		try {
			return cService.removeCustomer(custId);
		} catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException();
		}
	}

	@GetMapping("/id/{custId}")
	public Customer viewCustomer(@PathVariable int custId) {
		try {
			return cService.viewCustomer(custId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/all")
	public List<Customer> listAllCustomers() {
		return cService.listAllCustomers();
	}

}
