package com.cg.repository;

import java.util.List;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;

public interface IBrokerRepo {
	
	public Broker saveBroker(Broker bro);
	
	public Broker updateBroker(Broker bro);
	
	public Broker deleteBroker(int broId) throws BrokerNotFoundException;
	
	public Broker fetchBroker(int broId) throws BrokerNotFoundException;
	
	public List<Broker> fetchAllBrokers();
}
