package com.cg.service;

import com.cg.repository.ICustomerRepo;
import com.cg.repository.IDealRepo;
import com.cg.repository.IPropertyRepo;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.PasswordNotMatchException;

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
	
	@Autowired
	IDealRepo dDao;

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
		List<Deal> l= dDao.findAll();
		for(Deal i:l) {
			if(i.getCustomer().getUserId()==custId)
				dDao.delete(i);
		}
			
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
	
	@Override
	public Boolean signIn(Customer Customer) throws CustomerNotFoundException {
		Boolean status= false;
//		Optional<User> resultUser= userRepository.findById(user.getUserId());
		Optional<Customer> resultCustomer=cDao.findById(Customer.getUserId());
		if (resultCustomer.isPresent()) {
			if((resultCustomer.get().getPassword().equals(Customer.getPassword()))) 
			{
				status=true;

		} 
			else 
			
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return status;
	}
	
	@Override
	public Boolean  signOut(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Boolean status=false;
//		Optional<User> resultUser= userRepository.findById(user.getUserId());
		Optional<Customer> resultCustomer=cDao.findById(customer.getUserId());

		if (resultCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		else if(resultCustomer.get().getPassword().equals(customer.getPassword())) {
			 status = true;
		}
		return status;
	}
	/******************************************************************************
	 * Method                        changePassword
	 * Description                   It is used to change the password
	 * @param user                   User's refernce variable
	 * @throws PasswordNotMatchException 
	 * @UserNotFoundException        It is raised due to invalid user details
	 * created by                    p.saiteja reddy
	 * created date                  24-03-2021
	 ********************************************************************************/

	@Override

	public Customer changePassword(int custid, Customer customer) throws CustomerNotFoundException, PasswordNotMatchException {
		// TODO Auto-generated method stub
//		Optional<User> resultUser=userRepository.findById(id);
		Optional<Customer> resultCustomer=cDao.findById(customer.getUserId());
		if(resultCustomer.isPresent()) {
			resultCustomer.get().setPassword(customer.getPassword());
			return cDao.save(resultCustomer.get());
			
		}
		else
		{
			throw new CustomerNotFoundException("Customer Not Found");
		}	

}

}