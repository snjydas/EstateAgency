package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
/******************************************************************************
 * 
 * @author 			PATHAN ARSHIYA SHAHINA
 * Description 		It is a testing class that tests all the methods of Deal
 * Version			1.0
 * Created Date		30-MAR-2021
 ******************************************************************************/
@SpringBootTest
public class DealTest extends AbstractTest{
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	/*****************************************************************************
	 * Method			Test Method for get All Deals
	 * Description 		To check the working of get All Deals method in Deal Module 
	 * Created By		PATHAN ARSHIYA SHAHINA
	 * Created Date		30-MAR-2021
	 ******************************************************************************/
	@Test
	public void getAllDeals() throws Exception{
		String uri = "/real-estate-broker-application/deal";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status= mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		String content = mvcResult.getResponse().getContentAsString();
		Deal dealList[] = super.mapFromJson(content, Deal[].class);
		assertEquals(10000,dealList[0].getDealCost());
	}
	/*****************************************************************************
	 * Method			Test Method for create Deal
	 * Description 		To check the working of create Deal method in Deal Module 
	 * Created By		T. CHAITANYA
	 * Created Date		22-MAR-2021
	 ******************************************************************************/
	@Test
	public void createDeal() throws Exception{
		String uri = "/real-estate-broker-application/deal/add";
		Deal d= new Deal();
	    Customer c =new Customer();
	    c.setUserId(8);
	    Property p = new Property();
	    p.setPropId(13);
	    d.setCustomer(c);
	    d.setProperty(p);
	    d.setDealCost(900000);
	    String inputJson = super.mapToJson(d);
	    MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	    int status = mvcResult2.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult2.getResponse().getContentAsString();
		Deal d1= super.mapFromJson(content, Deal.class);
		assertEquals(13, d1.getProperty().getPropId());
	}
		
}
