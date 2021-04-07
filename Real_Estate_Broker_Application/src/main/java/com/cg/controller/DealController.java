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
import com.cg.exception.DealNotAvailableException;
import com.cg.repository.IDealRepo;
import com.cg.service.IDealService;
/***********************************************************************************************
 * @author 			PATHAN ARSHIYA SHAHINA
 * Description		It is a rest controller class that controls the data flow into model object
 					and updates the view whenever data changes
 * @version 		1.0
 * @since		    26-MAR-2021
 ***********************************************************************************************/

@RestController
@RequestMapping("real-estate-broker-application/deal")
public class DealController {
	@Autowired
	IDealService dealService;
	@Autowired
	IDealRepo dDao;

	/********************************************************************************************
	 * Method                          addDeal
     * Description                     It is used to add Deal to Deal entity
     * @param deal:                    Deal's reference variable.
	 * @returns Deal                   Newly created Deal details
	 * @PostMapping:                   Used to handle POST type of request method
	 * @RequestBody:                   It maps the HttpRequest body to a transfer or domain object
     * Created By                      PATHAN ARSHIYA SHAHINA
     * Created Date                    26-MAR-2021                            
	 
	 **********************************************************************************************/
	
	@PostMapping(value = "/add")
	public Deal addDeal(@RequestBody Deal deal) throws DealNotAvailableException {
//		try {
//			dDao.findById(deal.getDealId());
//		}
//		catch(Exception e) {
//			throw new DealNotAvailableException("Deal trying to edit does not exists");
//		}
		deal.setDealDate(LocalDate.now());
		deal.getProperty().setStatus(false);
		return dealService.addDeal(deal);
	}

	/********************************************************************************************
	 * Method                          	printAllDeal
     * Description                     	To get all Deal records from Deal entity
	 * @returns List                 	All Deal records
	 * @GetMapping                 		Used to handle GET type of request method
     *Created By                       	PATHAN ARSHIYA SHAHINA
     *Created Date                     	26-MAR-2021                            
	 
	 **********************************************************************************************/
	
	@GetMapping
	public List<Deal> printAllDeal() {
		return dealService.listAllDeals();
	}

}
