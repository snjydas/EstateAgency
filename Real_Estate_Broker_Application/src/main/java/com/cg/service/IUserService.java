package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.entity.User;

@Service
public interface IUserService {
	
	public User login(User user);
	public User logout(User user);

}
