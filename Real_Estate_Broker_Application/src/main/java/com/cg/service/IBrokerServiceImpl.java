package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.exception.PasswordNotMatchException;
import com.cg.repository.IBrokerRepo;

@Service
public class IBrokerServiceImpl implements IBrokerService {

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
		bro.setRole("Broker");
		bDao.saveAndFlush(bro);
		return bDao.findById(bro.getUserId()).get();
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		Broker b = bDao.findById(broId).get();
		bDao.deleteById(broId);
		return b;
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		return bDao.findById(broId).get();
	}

	@Override
	public List<Broker> listAllBrokers() {
		return bDao.findAll();
	}

	@Override
	public Boolean signIn(Broker Broker) throws BrokerNotFoundException {
		Boolean status= false;
//		Optional<User> resultUser= userRepository.findById(user.getUserId());
		Optional<Broker> resultBroker=bDao.findById(Broker.getUserId());
		if (resultBroker.isPresent()) {
			if((resultBroker.get().getPassword().equals(Broker.getPassword()))) 
			{
				status=true;

		} 
			else 
			
			throw new BrokerNotFoundException("Broker Not Found");
		}
		return status;
	}
	
	@Override
	public Boolean  signOut(Broker Broker) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		Boolean status=false;
//		Optional<User> resultUser= userRepository.findById(user.getUserId());
		Optional<Broker> resultBroker=bDao.findById(Broker.getUserId());

		if (resultBroker.isEmpty()) {
			throw new BrokerNotFoundException("Broker Not Found");
		}
		else if(resultBroker.get().getPassword().equals(Broker.getPassword())) {
			 status = true;
		}
		return status;
	}
	/******************************************************************************
	 * Method                        changePassword
	 * Description                   It is used to change the password
	 * @param user                   User's refernce variable
	 * @throws PasswordNotMatchException 
	 * @UserNotFoundException        It is raised due to invalid user details
	 * created by                    p.saiteja reddy
	 * created date                  24-03-2021
	 ********************************************************************************/

	
	@Override
	public Broker changePassword(int broid, Broker Broker) throws BrokerNotFoundException, PasswordNotMatchException {
		// TODO Auto-generated method stub
//		Optional<User> resultUser=userRepository.findById(id);
		Optional<Broker> resultBroker=bDao.findById(Broker.getUserId());
		if(resultBroker.isPresent()) {
				resultBroker.get().setPassword(Broker.getPassword());
				return bDao.save(resultBroker.get());
			
		}
		else
		{
			throw new BrokerNotFoundException("Broker Not Found");
		}	

}
}
