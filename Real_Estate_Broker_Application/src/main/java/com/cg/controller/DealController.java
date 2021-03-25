package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Deal;
import com.cg.service.IDealService;

@RestController
@RequestMapping("real-estate-broker-application/deal")
public class DealController {
	@Autowired
	IDealService dealService;

	@PostMapping(value = "/add")
	public Deal addDeal(@RequestBody Deal d) {
		d.setDealDate(LocalDate.now());
		d.getProperty().setStatus(false);
		return dealService.addDeal(d);
	}

	@GetMapping
	public List<Deal> printAllDeal() {
		return dealService.listAllDeals();
	}

}
