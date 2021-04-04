package com.cg.service;

import java.util.List;
import com.cg.entity.Deal;
import com.cg.exception.DealNotAvailableException;
/*************************************************************************************************************
 * @author 		PATHAN ARSHIYA SHAHINA
 * Description	It is an interface of service layer that provides various methods for its implementation class
 * @version		1.0
 * @since		23-MAR-2021 
 **************************************************************************************************************/

public interface IDealService {

	public Deal addDeal(Deal d) throws DealNotAvailableException;

	public List<Deal> listAllDeals();
}
