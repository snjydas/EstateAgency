package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;

public interface IBrokerService {
	
	public Broker addBroker(Broker bro);
	
	public Broker editBroker(Broker bro) throws BrokerNotFoundException;
	
	public Broker removeBroker(int broId) throws BrokerNotFoundException;
	
	public Broker viewBroker(int broId) throws BrokerNotFoundException;
	
	public List<Broker> listAllBrokers(); 
}
