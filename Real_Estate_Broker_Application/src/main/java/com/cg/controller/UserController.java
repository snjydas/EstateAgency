package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController

@RequestMapping(value = "real-estate-broker-application/user")
public class UserController {
	@Autowired
	private IUserService loginService;

	@PostMapping(value = "/login")
	public ResponseEntity<String> validateLogin(@RequestBody User user) {

		if (user != null) {
			User user1 = loginService.login(user);
			return new ResponseEntity<String>("Login Success", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("Login Failed, Please Try Again", HttpStatus.NOT_FOUND);
		}
	}

	@Autowired
	private IUserService logoutService;

	@DeleteMapping(value = "/logout")
	public ResponseEntity<String> validateLogout(@RequestBody User user) {
		User user1 = logoutService.login(user);

		if (user1 != null) {

			return new ResponseEntity<String>("Logout Success", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("Logout Failed, Please Try Again", HttpStatus.NOT_FOUND);
		}

	}
}
