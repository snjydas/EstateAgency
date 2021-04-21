package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.entity.Customer;
/******************************************************************************
 * 
 * @author 			ROOSA MOZOOMDAR
 * Description 		It is a testing class that tests all the methods of Customer
 * Version			1.0
 * Created Date		30-MAR-2021
 ******************************************************************************/
@SpringBootTest
public class CustomerTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	/*****************************************************************************
	 * Method			Test Method for get Customer
	 * Description 		To check the working of get Customer method in Customer Module 
	 * Created By		ROOSA MOZOOMDAR
	 * Created Date		30-MAR-2021
	 ******************************************************************************/
	@Test
	public void getCustomer() throws Exception {

		String uri = "/real-estate-broker-application/customer/id/6";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer c = super.mapFromJson(content, Customer.class);
		assertEquals("Hyderabad", c.getCity());
	}
	/*********************************************************************************
	 * Method			Test Method for get All Customer
	 * Description 		To check the working of get All Customer method in Customer Module
	 * Created By		ROOSA MOZOOMDAR
	 * Created Date		30-MAR-2021
	 *********************************************************************************/
	@Test
	public void getAllCustomer() throws Exception {
		String str = "/real-estate-broker-application/customer/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(str)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer customerList[] = super.mapFromJson(content, Customer[].class);
		assertEquals("Rakshith", customerList[1].getCustName());
	}
	/********************************************************************************
	 * Method			Test Method for delete Customer
	 * Description 		To check the working of delete Customer method in Customer Module
	 * Created By		ROOSA MOZOOMDAR
	 * Created Date		30-MAR-2021
	 *********************************************************************************/
	@Test
	public void deleteCustomer() throws Exception {
		String str = "/real-estate-broker-application/customer/remove/22";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(str)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer cust = super.mapFromJson(content, Customer.class);
		assertEquals("Vizayanagaram", cust.getCity());
	}
	/********************************************************************************
	 * Method			Test Method for create Customer
	 * Description 		To check the working of create Customer method in Customer Module 
	 * Created By		ROOSA MOZOOMDAR
	 * Created Date		30-MAR-2021
	 *********************************************************************************/
	@Test
	public void createCustomer() throws Exception {
		String str = "/real-estate-broker-application/customer/add";
		Customer cust = new Customer();
		cust.setCity("Mumbai");
		cust.setCustName("Damodhar");
		cust.setEmail("damodhar@gmail.com");
		cust.setMobile("9847589333");
		cust.setPassword("Dhumu@345");
		String inputJson = super.mapToJson(cust);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(str).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer customer = super.mapFromJson(content, Customer.class);
		assertEquals("9847589333", customer.getMobile());
	}
	/********************************************************************************
	 * Method			Test Method for update Customer
	 * Description 		To check the working of update Customer method in Customer Module
	 * Created By		ROOSA MOZOOMDAR
	 * Created Date		30-MAR-2021
	 ********************************************************************************/
	@Test
	public void updateCustomer() throws Exception {

		String uri = "/real-estate-broker-application/customer/update";
		String uri2 = "/real-estate-broker-application/customer/id/21";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri2)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		Customer c = super.mapFromJson(content, Customer.class);
		c.setCity("Chennai");
		String inputJson = super.mapToJson(c);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult1.getResponse().getStatus();
		assertEquals(200, status);
		String content1 = mvcResult1.getResponse().getContentAsString();
		Customer c1 = super.mapFromJson(content1, Customer.class);
		assertEquals("Chennai", c1.getCity());
	}

}
