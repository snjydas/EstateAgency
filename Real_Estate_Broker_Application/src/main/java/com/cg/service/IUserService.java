package com.cg.service;

import com.cg.entity.User;

public interface IUserService {
	
	User login(User user);
	
	User logout(User user);
}
