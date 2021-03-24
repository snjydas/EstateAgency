package com.cg.service;

import com.cg.repository.ICustomerRepo;
import com.cg.entity.Customer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepo cDao;

	@Override
	public Customer addCustomer(Customer customer) {
		cDao.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		cDao.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(int custId) {
		Customer c = cDao.findById(custId).get();
		cDao.deleteById(custId);
		return c;
	}

	@Override
	public Customer viewCustomer(int custId) {
		return cDao.findById(custId).get();
	}

	@Override
	public List<Customer> listAllCustomers() {
		return cDao.findAll();
	}

}