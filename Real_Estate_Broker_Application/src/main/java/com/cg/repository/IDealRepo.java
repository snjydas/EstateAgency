package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.entity.Deal;
/********************************************************************************************
 * @author		PATHAN ARSHIYA SHAHINA
 * Description	It is an interface extending JPA Repository for using already defined methods
 * @version		1.0
 * @since		22-MAR-2021
 ********************************************************************************************/
@Repository
public interface IDealRepo extends JpaRepository<Deal, Integer> {

}
