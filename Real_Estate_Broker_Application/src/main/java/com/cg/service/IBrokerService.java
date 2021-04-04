package com.cg.service;

import java.util.List;
import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;

/********************************************************************************************************
 * 
 * @author 		T. CHAITANYA
 * Description	It is an interface of service layer that provides various methods for its implementation class
 * Version		1.0
 * Created Date	23-MAR-2021 
 ********************************************************************************************************/



public interface IBrokerService {

	public Broker addBroker(Broker bro);

	public Broker editBroker(Broker bro) throws BrokerNotFoundException;

	public Broker removeBroker(int broId) throws BrokerNotFoundException;

	public Broker viewBroker(int broId) throws BrokerNotFoundException;

	public List<Broker> listAllBrokers();
}
