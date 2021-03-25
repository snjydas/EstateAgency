package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Broker;

@Repository
public interface IBrokerRepo extends JpaRepository<Broker, Integer> {

}
