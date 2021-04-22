
package com.cg.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.entity.User;
import com.cg.exception.PasswordNotMatchException;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.IUserRepository;

/**********************************************************************************
 * @author                 Sidda Reddy Partha Saradhi
 * Description             It is a user service implementation class that defines the methods
 *                         mentioned in its interface.
 * Version                 1.0
 * created date            25-MAR-2021
 *
 ****************************************************************************************/

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository uDao;
	
	/************************************************************************************
	 * Method                     signIn
	 * Description                It is used to sign In into application
	 * @param user                user's reference variable
	 * @UserNotFoundException     It is raised due to invalid user details
	 * created by                 Sidda Reddy Partha Saradhi
	 * created date               25-MAR-2021
	 ***********************************************************************************/

	@Override
	public boolean signIn(User user) throws UserNotFoundException {
		Boolean status= false;
//		Optional<User> resultUser= userRepository.findById(user.getUserId());
		Optional<User> resultBroker=uDao.findById(user.getUserId());
		if (resultBroker.isPresent()) {
			if((resultBroker.get().getPassword().equals(user.getPassword()))) 
			{
				status=true;

		} 
			else 
			
			throw new UserNotFoundException("User Not Found");
		}
		return status;
	}
	
	/*******************************************************************
	 * Method                                     signOut
	 * Description                                It is used to signout from application
	 * @param user                                user's reference variable
	 * @UserNotFoundException                     It raised due to invalid user details
	 * created by                                 Sidda Reddy Partha Saradhi
	 * Created date                               25-MAR-2021
	 ***********************************************************************/


	@Override
	public boolean  signOut(User user) throws UserNotFoundException {
		Boolean status=false;
		Optional<User> resultBroker=uDao.findById(user.getUserId());

		if (resultBroker.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		else if(resultBroker.get().getPassword().equals(user.getPassword())) {
			 status = true;
		}
		return status;
	}
	
	/******************************************************************************
	 * Method                        changePassword
	 * Description                   It is used to change the password
	 * @param user                   User's refernce variable
	 * @throws PasswordNotMatchException 
	 * @UserNotFoundException        It is raised due to invalid user details
	 * created by                     Sidda Reddy Partha Saradhi
	 * created date                  25-MAR-2021
	 ********************************************************************************/

	

	@Override
	public User changePassword(int userid, User user) throws UserNotFoundException, PasswordNotMatchException {

		Optional<User> resultUser=uDao.findById(user.getUserId());
		if(resultUser.isPresent()) {
				resultUser.get().setPassword(user.getPassword());
				return uDao.save(resultUser.get());
			
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}	

}

	@Override
	public List<User> getAllUsers() {
		
		return uDao.findAll();
	}

	@Override
	public User getUserById(int userId) {
		return uDao.findById(userId).get();
	}
	
}
