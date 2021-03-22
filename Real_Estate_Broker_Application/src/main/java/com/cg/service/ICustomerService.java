package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer editCustomer(Customer customer);

	public Customer removeCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer viewCustomer(int custid) throws CustomerNotFoundException;

	public List<Customer> listAllCustomers();
}
