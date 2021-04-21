package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Broker;
import com.cg.entity.Deal;
import com.cg.exception.BrokerNotFoundException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.repository.IBrokerRepo;
import com.cg.repository.IDealRepo;

/****************************************************************************************************************
 *         @author			T. CHAITANYA
 *         @Description  	It is a service class that provides methods for performing CRUD operations on Broker  
 *         @version        	1.0
 *         @since    		23-APR-2021
 ****************************************************************************************************************/

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
	 * Created Date		25-MAR-2021
	 *****************************************************/
	@Override
	public Broker addBroker(Broker bro) {
		bro.setRole("Broker");
		bDao.saveAndFlush(bro);
		return bro;
	}
	
	/*************************************************************************
	 * Method							editBroker
	 * Description						To update existing Broker in database
	 * @Param bro 						Updating Broker object
	 * @returns Broker					Updated Broker field in database
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
	 * Created By 						T. CHAITANYA
	 * Created Date						25-MAR-2021
	 *************************************************************************/
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
	 * Created Date						25-MAR-2021
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
	
	/*****************************************************************************************
	 * Method							viewBroker
	 * Description						To view Broker in database based on supplied Broker ID
	 * @Param broId 					Broker ID to be viewed
	 * @returns Broker					Broker record from database with broId
	 * @throws BrokerNotFoundException	It is raised due to invalid Broker ID
	 * Created By 						T. CHAITANYA
	 * Created Date						25-MAR-2021
	 *****************************************************************************************/
	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		return bDao.findById(broId).get();
	}
	
	/***************************************************************
	 * Method			listAllBrokers
	 * Description		To get the List of all Brokers from database
	 * @returns List	All Brokers from database
	 * Created By 		T. CHAITANYA
	 * Created Date		25-MAR-2021
	 ****************************************************************/
	@Override
	public List<Broker> listAllBrokers() {
		return bDao.findAll();
	}

	
}
