package com.cg.service;

import com.cg.repository.ICustomerRepo;
import com.cg.repository.IDealRepo;
import com.cg.repository.IPropertyRepo;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.CustomerNotFoundException;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/***************************************************************************************************************************
 *         @author			ROOSA MOZOOMDAR
 *         @Description  	It is a service class that provides methods for performing CRUD and other operations on Customer  
 *         @version        	1.0
 *         @since    		23-MAR-2021
 ***************************************************************************************************************************/
@Service
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepo cDao;

	@Autowired
	IPropertyRepo pDao;
	
	@Autowired
	IDealRepo dDao;

	/*******************************************************
	 * Method			 addCustomer
	 * Description		 To add new Customer to database
	 * @Param customer   New Customer object
	 * @returns Customer created Customer field in database
	 * Created By 		 ROOSA MOZOOMDAR
	 * Created Date		 23-MAR-2021
	 *******************************************************/
	
	@Override
	public Customer addCustomer(Customer customer) {
		customer.setRole("Customer");
		cDao.saveAndFlush(customer);
		return customer;
	}
	
	/*******************************************************
	 * Method			 editCustomer
	 * Description		 To update Customer in the database
	 * @Param customer   updated Customer object
	 * @returns Customer updated customer 
	 * Created By 		 ROOSA MOZOOMDAR
	 * Created Date		 23-MAR-2021
	 *******************************************************/

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

	/*******************************************************************************
	 * Method			 					removeCustomer
	 * Description		 					To delete Customer in the database
	 * @Param custId 	 					Customer Id which should delete
	 * @returns Customer 					deleted customer 
	 * @throws CustomerNotFoundException	It is raised due to invalid Customer ID
	 * Created By 		 					ROOSA MOZOOMDAR
	 * Created Date							23-MAR-2021
	 *******************************************************************************/
	
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


	/*****************************************************************************************
	 * Method			 					viewCustomer
	 * Description		 					To get Customer in the database with particular Id
	 * @Param custId 	 					Customer Id of the required Customer
	 * @returns Customer 					Customer with given Id 
	 * @throws CustomerNotFoundException	It is raised due to invalid Customer ID
	 * Created By 		 					ROOSA MOZOOMDAR
	 * Created Date							23-MAR-2021
	 ******************************************************************************************/
	
	@Override
	public Customer viewCustomer(int custId) throws CustomerNotFoundException {
		return cDao.findById(custId).get();
	}
	
	/*****************************************************************************************
	 * Method			 					listAllCustomers
	 * Description		 					To get Customer all the database
	 * @returns List 					    All Customers as a List 
	 * Created By 		 					ROOSA MOZOOMDAR
	 * Created Date							23-MAR-2021
	 ******************************************************************************************/

	@Override
	public List<Customer> listAllCustomers() {
		return cDao.findAll();
	}
	
	

}