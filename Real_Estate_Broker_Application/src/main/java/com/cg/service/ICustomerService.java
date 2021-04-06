package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
/*************************************************************************************************************
 * @author 		ROOSA MOZOOMDAR
 * Description	It is an interface of service layer that provides various methods for its implementation class
 * @version		1.0
 * @since		25-MAR-2021 
 **************************************************************************************************************/

public interface ICustomerService {

	public Customer addCustomer(Customer customer);

	public Customer editCustomer(Customer customer);

	public Customer removeCustomer(int custId) throws CustomerNotFoundException;

	public Customer viewCustomer(int custid) throws CustomerNotFoundException;

	public List<Customer> listAllCustomers();

	
}
