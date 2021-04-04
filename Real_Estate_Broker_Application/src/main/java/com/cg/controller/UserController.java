package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.exception.PasswordNotMatchException;
import com.cg.exception.UserNotFoundException;
import com.cg.service.IUserService;

@RestController

@RequestMapping(value = "real-estate-broker-application/user")
public class UserController {
	@Autowired
	private IUserService uService;

	@PostMapping(value = "/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user) throws UserNotFoundException {
		return new ResponseEntity<Boolean>(uService.signIn(user),HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user) throws UserNotFoundException{
		return new ResponseEntity<Boolean>(uService.signOut(user),HttpStatus.OK);
	}
	@PutMapping("/updatepassword")
	public ResponseEntity<User> updatePassword(@RequestBody User user) throws UserNotFoundException, PasswordNotMatchException{
		return new ResponseEntity<User>(uService.changePassword(user.getUserId(), user),HttpStatus.OK);
	}

}
