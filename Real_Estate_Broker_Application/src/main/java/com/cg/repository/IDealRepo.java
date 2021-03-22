package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;

public interface IDealRepo extends JpaRepository<Deal,Integer> {

	public Deal saveDeal(Property property, Customer customer);
	
	public List<Deal> fetchAllDeals();
	
}
