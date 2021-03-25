package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;

@Repository
public interface IDealRepo extends JpaRepository<Deal, Integer> {

}
