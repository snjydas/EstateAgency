package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/***************************************************************************
 * 
 * @author 			Sidda Reddy Partha Saradhi
 * Description 		It is an entity class that provides all the fields of User
 * Version			1.0
 * Created Date		23-MAR-2021
 ***************************************************************************/

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String password;
	private String role;
	@Column(unique = true)
	private String mobile;
	@Column(unique = true)
	private String email;
	private String city;
	public User(String password, String role, String mobile, String email, String city) {
		super();
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}
	public User() {
		super();
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Id of the user
	 * @returns int     User Id
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public int getUserId() {
		return userId;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Id of the user
	 * @returns void
	 * @param int 		userid
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public void setUserId(int userid) {
		this.userId = userid;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Password of the user
	 * @returns String  User Password
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public String getPassword() {
		return password;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Password of the user
	 * @returns void
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public void setPassword(String password) {
		this.password = password;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Role of the user
	 * @returns String	User Role
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public String getRole() {
		return role;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Role of the user
	 * @returns Void    
	 * @param String	role
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public void setRole(String role) {
		this.role = role;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Mobile number of the user
	 * @returns String  User mobile number
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public String getMobile() {
		return mobile;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Id of the user
	 * @returns void
	 * @param String	mobile
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get Email of the user
	 * @returns String  User Email
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public String getEmail() {
		return email;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Email of the user
	 * @returns String  User Email
	 * @param String	email
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public void setEmail(String email) {
		this.email = email;
	}
	/*******************************************
	 * Method			Getter Method
	 * Description 		To get City of the user
	 * @returns String  User city
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public String getCity() {
		return city;
	}
	/*******************************************
	 * Method			Setter Method
	 * Description 		To set Id of the user
	 * @returns void
	 * @param String 	city
	 * Created By		Sidda Reddy Partha Saradhi
	 * Created Date		28-MAR-2021
	 *******************************************/
	public void setCity(String city) {
		this.city = city;
	}
	
}
