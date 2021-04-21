package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.entity.User;
import com.cg.repository.IUserRepository;
/******************************************************************************
 * 
 * @author 			Sidda Reddy Partha Saradhi
 * Description 		It is a testing class that tests all the methods of User
 * Version			1.0
 * Created Date		30-MAR-2021
 ******************************************************************************/
@SpringBootTest
public class UserTest extends AbstractTest {

	@Autowired
	IUserRepository uDao;
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	/*****************************************************************************
	 * Method			Test Method for user login
	 * Description 		To check the working of user login method in Login Module 
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		30-MAR-2021
	 ******************************************************************************/
	@Test
	public void userLogin() throws Exception{
		String uri = "/real-estate-broker-application/user/login";
		User user = new User();
		user.setUserId(1);
		user.setPassword("Jagan@123");
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("true",content);
	}
	/*****************************************************************************
	 * Method			Test Method for user logout
	 * Description 		To check the working of user logout method in Login Module 
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		30-MAR-2021
	 ******************************************************************************/
	@Test
	public void userLogout() throws Exception{
		String uri = "/real-estate-broker-application/user/logout";
		User user = new User();
		user.setUserId(1);
		user.setPassword("Jagan@123");
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("true",content);
	}
	
	/*****************************************************************************
	 * Method			Test Method for update password 
	 * Description 		To check the working of update password method in Login Module 
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		30-MAR-2021
	 ******************************************************************************/
	@Test
	public void updatePassword() throws Exception{
		String uri = "/real-estate-broker-application/user/updatepassword";
		User user = new User();
		user.setUserId(1);
		user.setPassword("Jagan@1234");
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		User user1= uDao.findById(1).get();
		assertEquals("Jagan@1234",user1.getPassword());
	}
}
