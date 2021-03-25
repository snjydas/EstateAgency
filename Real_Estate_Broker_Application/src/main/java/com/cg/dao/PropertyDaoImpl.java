package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PropertyDaoImpl implements PropertyDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Property> fetchAllProperties() {
		TypedQuery<Property> q = em.createQuery("select p from Property p", Property.class);
		return q.getResultList();
	}

	@Override
	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria) {
		TypedQuery<Property> q = em.createQuery("select p from Property p where p.configuration =:i", Property.class);
		q.setParameter("i", criteria.getConfig());
		return q.getResultList();
	}
}
