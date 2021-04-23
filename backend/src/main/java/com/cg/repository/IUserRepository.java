package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.entity.User;

/********************************************************************************************
 * @author		Sidda Reddy Partha Saradhi
 * Description	It is an interface extending JPA Repository for using already defined methods
 * @version		1.0
 * @since		24-MAR-2021
 ********************************************************************************************/
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
}
