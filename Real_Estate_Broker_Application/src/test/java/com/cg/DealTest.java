package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.entity.Broker;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;

@SpringBootTest
public class DealTest extends AbstractTest{
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	
	@Test
	public void getAllDeals() throws Exception{
		String uri = "/real-estate-broker-application/deal";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status= mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		String content = mvcResult.getResponse().getContentAsString();
		Deal dealList[] = super.mapFromJson(content, Deal[].class);
		assertEquals(900000,dealList[0].getDealCost());
	}
	
	@Test
	public void createDeal() throws Exception{
		String uri = "/real-estate-broker-application/deal/add";
		Deal d= new Deal();
	    
	    Customer c =new Customer();
	    c.setUserId(32);
	    Property p = new Property();
	    p.setPropId(5);
	    d.setCustomer(c);
	    d.setProperty(p);
	    d.setDealCost(900000);
	    String inputJson = super.mapToJson(d);
	    MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	    int status = mvcResult2.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult2.getResponse().getContentAsString();
		Deal d1= super.mapFromJson(content, Deal.class);
		assertEquals(5, d1.getCustomer().getUserId());
	}
		
}
