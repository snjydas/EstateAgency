package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.PasswordNotMatchException;
import com.cg.exception.UserNotFoundException;

@Service
public interface IUserService {


	Boolean signIn(User user) throws UserNotFoundException;

	Boolean signOut(User user) throws UserNotFoundException;

	/******************************************************************************
	 * Method                        changePassword
	 * Description                   It is used to change the password
	 * @param broker                 Broker's refernce variable
	 * @throws PasswordNotMatchException 
	 * @BrokerNotFoundException        It is raised due to invalid user details
	 * created by                    Sidda Reddy Partha Saradhi
	 * created date                  24-03-2021
	 ********************************************************************************/
	User changePassword(int userid, User user) throws UserNotFoundException, PasswordNotMatchException;

}
