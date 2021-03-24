package com.cg.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.User;
import com.cg.exception.InvalidEmailException;
import com.cg.exception.InvalidPasswordException;
import com.cg.repository.IUserRepository;

@SpringBootTest
public class LoginServiceTests {

	@Autowired
	IUserService loginService;

	@MockBean
	IUserRepository repository;

	@Test
	public void TestLoginLogin() {
		User user = new User();
		user.setEmail("saradhi123@gmail.com");
		user.setPassword("saradhi@123");

		Mockito.when(loginService.login(user)).thenReturn(user);
		User user1 = loginService.login(user);
		Assertions.assertEquals(user, user1);
	}

	@Test
	void TestLoginInvalidEmailException() {
		User user1 = new User();
		user1.setEmail("saradhi123@gmail.@com");
		user1.setPassword("saradhi@123");

		Mockito.when(loginService.login(user1)).thenThrow(new InvalidEmailException());
		Assertions.assertThrows(InvalidEmailException.class, () -> loginService.login(user1));

	}

	@Test
	void TestLoginInvalidPasswordException() {
		User user = new User();
		user.setEmail("saradhi123@gmail.com");
		user.setPassword("saradhi@@123");

		Mockito.when(loginService.login(user)).thenThrow(new InvalidPasswordException());
		Assertions.assertThrows(InvalidPasswordException.class, () -> loginService.login(user));

	}
}
