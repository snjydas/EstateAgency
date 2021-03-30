package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.PasswordNotMatchException;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);

	public Customer editCustomer(Customer customer);

	public Customer removeCustomer(int custId) throws CustomerNotFoundException;

	public Customer viewCustomer(int custid) throws CustomerNotFoundException;

	public List<Customer> listAllCustomers();

	Boolean signIn(Customer Customer) throws CustomerNotFoundException;

	Boolean signOut(Customer customer) throws CustomerNotFoundException;

	
	Customer changePassword(int Custid, Customer customer) throws CustomerNotFoundException, PasswordNotMatchException;
}
