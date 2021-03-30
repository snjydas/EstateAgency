package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Broker;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.BrokerNotFoundException;
import com.cg.exception.PasswordNotMatchException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.repository.IBrokerRepo;
import com.cg.repository.IDealRepo;
import com.cg.repository.IPropertyRepo;
/************************************************************************************
 *          @author			T. CHAITANYA
 *          Description  	It is a service class that provides methods for performing CRUD operations on Broker  
 *         Version        	1.0
 *         Created Date    	02-APR-2020
 ************************************************************************************/

@Service
public class IBrokerServiceImpl implements IBrokerService {

	@Autowired
	IBrokerRepo bDao;
	
	@Autowired
	IDealRepo dDao;
	

	/*****************************************************
	 * Method			addBroker
	 * Description		To add new Broker to database
	 * @Param bro 		New Broker object
	 * @returns Broker	created Broker field in database
	 * Created By 		T. CHAITANYA
	 * Created Date		30-MAR-2021
	 *****************************************************/
	@Override
	public Broker addBroker(Broker bro) {
		bro.setRole("Broker");
		bDao.saveAndFlush(bro);
		return bro;
	}
	/*****************************************************
	 * Method							editBroker
	 * Description						To update existing Broker in database
	 * @Param bro 						Updating Broker object
	 * @returns Broker					Updated Broker field in database
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
	 * Created By 						T. CHAITANYA
	 * Created Date						30-MAR-2021
	 *****************************************************/
	@Override
	public Broker editBroker(Broker bro) throws BrokerNotFoundException {
		bro.setRole("Broker");
		bDao.saveAndFlush(bro);
		return bDao.findById(bro.getUserId()).get();
	}
	/*****************************************************
	 * Method							removeBroker
	 * Description						To delete Broker from database
	 * @Param broId 					Broker ID to be deleted
	 * @returns Broker					deleted Broker field
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
	 * Created By 						T. CHAITANYA
	 * Created Date						30-MAR-2021
	 * @throws PropertyNotFoundException 
	 *****************************************************/
	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		List<Deal> l= dDao.findAll();
		for(Deal i:l) {
			if(i.getProperty().getBroker().getUserId()==broId) {
				dDao.delete(i);

			}
		}
		
		
		
		Broker b = bDao.findById(broId).get();
		bDao.deleteById(broId);
		return b;
	}
	/**************************************************************************
	 * Method							viewBroker
	 * Description						To view Broker in database based on supplied Broker ID
	 * @Param broId 					Broker ID to be viewed
	 * @returns Broker					Broker record from database with broId
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
	 * Created By 						T. CHAITANYA
	 * Created Date						30-MAR-2021
	 ****************************************************************************/
	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		return bDao.findById(broId).get();
	}
	/***************************************************************
	 * Method			listAllBrokers
	 * Description		To get the List of all Brokers from database
	 * @returns List	All Brokers from database
	 * Created By 		T. CHAITANYA
	 * Created Date		30-MAR-2021
	 ****************************************************************/
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
