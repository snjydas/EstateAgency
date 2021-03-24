package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dao.PropertyDao;
import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;

@Repository
public interface IPropertyRepo extends PropertyDao, JpaRepository<Property, Integer> {

	public List<Property> fetchAllProperties();

	public List<Property> findPropertyByCriteria(PropertyCriteria criteria);

}
