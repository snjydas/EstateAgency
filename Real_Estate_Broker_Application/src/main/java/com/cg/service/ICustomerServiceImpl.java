package com.cg.service;

import com.cg.repository.ICustomerRepo;
import com.cg.repository.IPropertyRepo;
import com.cg.entity.Customer;
import com.cg.entity.Property;
import com.cg.exception.CustomerNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepo cDao;

	@Autowired
	IPropertyRepo pDao;

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setRole("Customer");
		cDao.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		customer.setRole("Customer");
		List<Integer> l = customer.getProperties().stream().map(p -> p.getPropId()).collect(Collectors.toList());
		List<Property> p = new ArrayList<Property>();
		for (int i : l) {
			p.add(pDao.findById(i).get());
		}
		customer.setProperties(p);
		cDao.save(customer);
		return cDao.findById(customer.getUserId()).get();
	}

	@Override
	public Customer removeCustomer(int custId) throws CustomerNotFoundException {
		Customer c = cDao.findById(custId).get();
		cDao.deleteById(custId);
		return c;
	}

	@Override
	public Customer viewCustomer(int custId) throws CustomerNotFoundException {
		return cDao.findById(custId).get();
	}

	@Override
	public List<Customer> listAllCustomers() {
		return cDao.findAll();
	}

}