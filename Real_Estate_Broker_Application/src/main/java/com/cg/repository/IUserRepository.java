package com.cg.repository;

import com.cg.entity.User;

public interface IUserRepository {
	
	User login(User user);
	
	User logout(User user);
}
