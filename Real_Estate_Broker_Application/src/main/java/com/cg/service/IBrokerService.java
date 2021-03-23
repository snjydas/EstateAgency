package com.cg.service;

import java.util.List;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;

public interface IBrokerService {

	Broker addBroker(Broker bro);

	Broker editBroker(Broker bro) throws BrokerNotFoundException;

	Broker removeBroker(int broId) throws BrokerNotFoundException;

	Broker viewBroker(int broId) throws BrokerNotFoundException;

	List<Broker> listAllBrokers();
}
