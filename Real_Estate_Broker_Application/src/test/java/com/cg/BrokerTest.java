package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.entity.Broker;
import com.cg.entity.Property;
import com.cg.service.IBrokerService;

@SpringBootTest
public class BrokerTest extends AbstractTest{
	@Autowired
	IBrokerService iSer;
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getBroker() throws Exception{
		String uri = "/real-estate-broker-application/broker/id/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		String content = mvcResult.getResponse().getContentAsString();
		Broker bro = super.mapFromJson(content, Broker.class);
		assertEquals("bname1",bro.getBroName());
	}
	
	
	@Test
	public void getAllBroker() throws Exception{
		String uri = "/real-estate-broker-application/broker/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		String content = mvcResult.getResponse().getContentAsString();
		Broker brokerList[] = super.mapFromJson(content, Broker[].class);
		assertEquals("bname1",brokerList[0].getBroName());
	}
	
	
	@Test
	public void createBroker() throws Exception{
		String uri = "/real-estate-broker-application/broker/add";
		List<Property> p = new ArrayList<Property>();
		Broker bro = new Broker();
		bro.setPassword("password2");
		bro.setRole("Broker");
		bro.setMobile("mobile4");
		bro.setEmail("email4");
		bro.setCity("city3");
		bro.setBroName("name3");
		bro.setProperties(p);
		String inputJson = super.mapToJson(bro);
		System.out.println("==========================="+inputJson+"======================================");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Broker broker = super.mapFromJson(content, Broker.class);
		assertEquals("Broker", broker.getRole());
	}
	
	
	
	//********Not working properly*************
	
	@Test
	public void updateBroker() throws Exception{
		
		String uri = "/real-estate-broker-application/broker/update";
		String uri2 = "/real-estate-broker-application/broker/id/9";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri2)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		Broker b = super.mapFromJson(content, Broker.class);
		b.setCity("city3");
		String inputJson = super.mapToJson(b);
		MvcResult mvcResult1 = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult1.getResponse().getStatus();
		assertEquals(200, status);
		String content1 = mvcResult1.getResponse().getContentAsString();
		Broker b1 = super.mapFromJson(content1, Broker.class);
		assertEquals("city3", b1.getCity());
	}
	
	//****working********
	
//	@Test
//	public void updateBroker() throws BrokerNotFoundException {
//		List<Property> li = new ArrayList<Property>();
//		Broker bro = new Broker("pass3","Broker", "0123456789", "email33", "hyd", "Howle",li);
//		
//		iSer.addBroker(bro);
//		bro.setBroName("Bakra");
//		iSer.editBroker(bro);
//		assertEquals("Bakra", iSer.viewBroker(5).getBroName());
//	}
	
	@Test
	public void deleteBroker() throws Exception{
		String uri = "/real-estate-broker-application/broker/remove/16";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		String content = mvcResult.getResponse().getContentAsString();
		Broker bro = super.mapFromJson(content, Broker.class);
		assertEquals("city3",bro.getCity());
	}
}
