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

/***********************************************************************************************
 * @author 			Sidda Reddy Partha Saradhi
 * Description		It is a rest controller class that controls the data flow into model object
 					and updates the view whenever data changes
 * @version 		1.0
 * @since		    26-MAR-2021
 ***********************************************************************************************/

@RestController

@RequestMapping(value = "real-estate-broker-application/user")
public class UserController {
	@Autowired
	private IUserService uService;
	/****************************************************************************
	 * Method                         loginUser
	 * Description                    It is used to login into online application
	 * @param user                    user reference variable
	 * @return                        return true if user details is correct or else false
	 * @throws UserNotFoundException  it is raises due to invalid user details
	 * Created By                      Sidda Reddy Partha Saradhi
     * Created Date                    26-MAR-2021   
	 */

	@PostMapping(value = "/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) throws UserNotFoundException {
		return new ResponseEntity<String>(uService.signIn(user),HttpStatus.OK);
	}
	/*******************************************************************************
	 * Method                        logoutUser
	 * Description                   It is used to logout from online application
	 * @param user                   user reference variable
	 * @return
	 * @throws UserNotFoundException
	 * Created By                      Sidda Reddy Partha Saradhi
     * Created Date                    26-MAR-2021  
	 */
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestBody User user) throws UserNotFoundException{
		return new ResponseEntity<String>(uService.signOut(user),HttpStatus.OK);
	}
	
	/*******************************************************************************
	 * Method                      updatePassword
	 * Description                 It is used to update the password
	 * @param user                 user reference variable
	 * @return
	 * @throws UserNotFoundException
	 * Created By                      Sidda Reddy Partha Saradhi
     * Created Date                    26-MAR-2021  
	 */
	
	@PutMapping("/updatepassword")
	public ResponseEntity<User> updatePassword(@RequestBody User user) throws UserNotFoundException, PasswordNotMatchException{
		return new ResponseEntity<User>(uService.changePassword(user.getUserId(), user),HttpStatus.OK);
	}

}
