package com.cg.repository;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;

public interface ICustomerRepo {

	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer fetchCustomer(int custid) throws CustomerNotFoundException;

	public List<Customer> fetchAllCustomers();
}
