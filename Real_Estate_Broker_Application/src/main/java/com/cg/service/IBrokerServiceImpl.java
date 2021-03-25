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
		bro.setRole("Broker");
		bDao.saveAndFlush(bro);
		return bro;
	}

	@Override
	public Broker editBroker(Broker bro) throws BrokerNotFoundException {
<<<<<<< HEAD
		bro.setRole("Broker");
		bDao.saveAndFlush(bro);
=======

		bro.setRole("Broker");
		bDao.saveAndFlush(bro);

		try {
			bDao.findById(bro.getUserid());
			bDao.saveAndFlush(bro);
		} catch (Exception e) {
			throw new BrokerNotFoundException("Given Broker is inappropriate!");
		}
>>>>>>> 694e9c0d92ec34e18b732ac8142f3b342b98d370
		return bro;
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		Broker b = bDao.findById(broId).get();
		bDao.deleteById(broId);
		return b;
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		Optional<Broker> op = bDao.findById(broId);
		if(op.isPresent()) {
			return op.get();
		}	
		else	
		throw new BrokerNotFoundException("Broker with given ID not found,Please Recheck the input!");
	}

	@Override
	public List<Broker> listAllBrokers() {
		return bDao.findAll();
	}
	

}
