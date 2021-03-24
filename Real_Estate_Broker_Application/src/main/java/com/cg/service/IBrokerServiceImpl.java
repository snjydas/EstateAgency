package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.repository.IBrokerRepo;


@Service
public class IBrokerServiceImpl implements IBrokerService{

	@Autowired
	IBrokerRepo bDao;
	@Override
	public Broker addBroker(Broker bro) {
		bDao.saveAndFlush(bro);
		return bro;
	}

	@Override
	public Broker editBroker(Broker bro) throws BrokerNotFoundException {
		try {
			bDao.findById(bro.getUserid());
			bDao.saveAndFlush(bro);
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Given Broker is inappropriate!");
		}
		return bro;
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		Optional<Broker> op = bDao.findById(broId);
		if(op.isPresent()) {
			bDao.deleteById(broId);
			return op.get();
		}	
		else	
		throw new BrokerNotFoundException("Broker with given ID not found,Please Recheck the input!");
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		return bDao.findById(broId).get();
	}

	@Override
	public List<Broker> listAllBrokers() {
		return bDao.findAll();
	}
	

}
