package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.repository.IUserRepository;

@Service
public class LoginServiceImpl implements IUserService {

	@Autowired
	private IUserRepository loginRepository;

	@Override
	public User login(User user) {
		User user1 = loginRepository.saveAndFlush(user);
		return user1;
	}

	@Autowired
	private IUserRepository logoutRepository;

	@Override
	public User logout(User user) {
		logoutRepository.delete(user);
		return user;
	}
}