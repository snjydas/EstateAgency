package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/********************************************************************************************
 * @author		T. CHAITANYA
 * Description	It is an interface extending JPA Repository for using already defined methods
 * Version		1.0
 * Created Date	22-MAR-2021
 ********************************************************************************************/
import com.cg.entity.Broker;

@Repository
public interface IBrokerRepo extends JpaRepository<Broker, Integer> {

}
