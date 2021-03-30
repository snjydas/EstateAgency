package com.cg.service;

import java.util.List;
import com.cg.entity.Deal;
import com.cg.exception.DealNotAvailableException;

public interface IDealService {

	public Deal addDeal(Deal d) throws DealNotAvailableException;

	public List<Deal> listAllDeals();
}
