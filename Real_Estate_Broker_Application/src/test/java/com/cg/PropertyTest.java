package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.entity.Broker;
import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;

@SpringBootTest
public class PropertyTest extends AbstractTest {
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getProperty() throws Exception{
		String uri="/real-estate-broker-application/property/id/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Property p = super.mapFromJson(content, Property.class);
		assertEquals("padd1", p.getAddress());
	}
	
	@Test
	public void createProperty() throws Exception{
		String uri="/real-estate-broker-application/property/add";
		Property p= new Property();
		p.setAddress("padd2");
		p.setAreaSqft(600000);
		Broker b= new Broker();
		b.setUserId(9);
		p.setBroker(b);
		p.setCity("city5");
		p.setConfiguration("Flat");
		p.setOfferCost(900000);
		p.setOfferType("Rent");
		p.setStreet("street2");
		p.setStatus(true);
		
		String inputJson=super.mapToJson(p);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Property p1=super.mapFromJson(content, Property.class);
		assertEquals("padd2",p1.getAddress());
		
	}
	
	@Test
	public void getAllProperties() throws Exception{
		String uri="/real-estate-broker-application/property/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Property p[] = super.mapFromJson(content, Property[].class);
		assertEquals("padd1", p[0].getAddress());
	}
	
	@Test
	public void deleteProperty() throws Exception{
		String uri="/real-estate-broker-application/property/remove/33";
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Property p=super.mapFromJson(content, Property.class);
		assertEquals("city5", p.getCity());
	}
	
	@Test
	public void editProperty() throws Exception{
		String uri1="/real-estate-broker-application/property/update";
		
		
		String uri="/real-estate-broker-application/property/id/22";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		Property p = super.mapFromJson(content, Property.class);
		p.setAddress("padd45");
		String inputJson = super.mapToJson(p);
		MvcResult mvcResult1=mvc.perform(MockMvcRequestBuilders.put(uri1).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		String content1 = mvcResult1.getResponse().getContentAsString();
		Property p1=super.mapFromJson(content1, Property.class);
		assertEquals("padd45", p1.getAddress());
		 
	}
	
	@Test 
	public void getPropertyByPropertyCriteria() throws Exception{
		String uri = "/real-estate-broker-application/property/criteria";
		
		PropertyCriteria pc= new PropertyCriteria();
		pc.setCity("city4");
		String inputJson = super.mapToJson(pc);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Property p[] = super.mapFromJson(content, Property[].class);
		assertEquals(60000, p[0].getOfferCost());
	}

}
