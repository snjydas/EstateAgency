package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.service.IDealService;

@RestController
@RequestMapping("/deal")
public class DealController {
	@Autowired
	IDealService dealService;

	@PostMapping(value = "/add")
	public Deal addDeal(@RequestBody Property property, Customer customer) {
		return dealService.addDeal(property, customer);
	}

	@GetMapping
	public List<Deal> printAllDeal() {
		return dealService.listAllDeals();
	}

}
