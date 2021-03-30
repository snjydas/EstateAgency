package com.cg.service;

import java.util.List;
import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;

/********************************************************************************************************
 * 
 * @author 		T. CHAITANYA
 * Description	It is an interface of service layer that provides various methods for its implementation class
 * Version		1.0
 * Created Date	30-MAR-2021 
 ********************************************************************************************************/

import com.cg.exception.PasswordNotMatchException;


public interface IBrokerService {

	public Broker addBroker(Broker bro);

	public Broker editBroker(Broker bro) throws BrokerNotFoundException;

	public Broker removeBroker(int broId) throws BrokerNotFoundException;

	public Broker viewBroker(int broId) throws BrokerNotFoundException;

	public List<Broker> listAllBrokers();

	Boolean signIn(Broker broker) throws BrokerNotFoundException;

	Boolean signOut(Broker Broker) throws BrokerNotFoundException;

	Broker changePassword(int broid, Broker Broker) throws BrokerNotFoundException, PasswordNotMatchException;
}
