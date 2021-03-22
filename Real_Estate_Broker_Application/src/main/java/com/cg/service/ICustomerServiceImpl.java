package com.cg.service;

import com.cg.repository.ICustomerRepo;
import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepo cDao;

	@Override
	public Customer addCustomer(Customer customer) {
		cDao.saveCustomer(customer);
		return (Customer) cDao.fetchAllCustomers();
	}

	@Override
	public Customer editCustomer(Customer customer) {
		cDao.updateCustomer(customer);
		return (Customer) cDao.fetchAllCustomers();
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerNotFoundException{
		if ((cDao.fetchCustomer(custId)).isPresent()) {
			return cDao.deleteCustomer(customer);
		} 
		else {
			throw new CustomerNotFoundException();
		}
	}

	@Override
	public Customer removeCustomer(int custId) {
		return (Customer) cDao.deleteCustomer(custId);
	}

	@Override
	public Customer viewCustomer(int custId) //throws CustomerNotFoundException {
		if (cDao.fetchCustomer(custId).isPresent()) {
			return cDao.fetchCustomer(custId);
		} else {
		throw new CustomerNotFoundException();
		}	
	}

	@Override
	public Customer viewCustomer(int custId) {
		return cDao.fetchCustomer(custId);
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerNotFoundException {
		return (Customer) cDao.deleteCustomer(customer);
	}

	@Override
	public List<Customer> listAllCustomers() {
		return cDao.fetchAllCustomers();
	}

}