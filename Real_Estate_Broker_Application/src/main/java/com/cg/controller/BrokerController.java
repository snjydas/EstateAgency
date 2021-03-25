package com.cg.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.service.IBrokerService;

@RestController
@RequestMapping("/broker")
public class BrokerController {
	@Autowired
	IBrokerService bService;
	
	@PostMapping("/add")
	public Broker addBroker(@RequestBody Broker bro) {
		
		return bService.addBroker(bro);
	}
	@PutMapping("/update")
	public Broker editBroker(@RequestBody Broker bro) throws BrokerNotFoundException{
		try {
			viewBroker(bro.getUserid());
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Given Broker is inappropriate!");
		}
		return bService.editBroker(bro);
	}
	@DeleteMapping("/remove/{broId}")
	public Broker removeBroker(@PathVariable int broId) throws BrokerNotFoundException{
		try {
			viewBroker(broId);
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Broker with given Broker ID not found, Please recheck input!");
		}
		return bService.removeBroker(broId);
	}
	@GetMapping("/all")
	public List<Broker> listAllBrokers(){
		return bService.listAllBrokers();
	}
	@GetMapping("/get/{broId}")
	public Broker viewBroker(@PathVariable int broId) throws BrokerNotFoundException{
		try {
			bService.viewBroker(broId);
		}
		catch(Exception e) {
			throw new BrokerNotFoundException("Broker with given ID is not found, Please Recheck the input!");
		}
		return bService.viewBroker(broId);
	}
}
