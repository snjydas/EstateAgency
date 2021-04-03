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
	/***********************************************************************************************
	 * @author 			Rakshith Vuppala
	 * Description		It is a dao layer which is used to get all properties and all properties with
	 * 					given criteria
	 * @version			1.0
	 * @since    		30-MAR-2021
	 ***********************************************************************************************/
	@PersistenceContext
	EntityManager em;
	
	/********************************************************************************************
	 * Method                          fetchAllProperties
     * Description                     It is used to get all Property from Property entity
	 * @returns List  	               All Properties
     * Created By                      Rakshith Vuppala
     * Created Date                    30-MAR-2021                            
	 
	 **********************************************************************************************/
	
	@Override
	public List<Property> fetchAllProperties() {
		TypedQuery<Property> q = em.createQuery("select p from Property p", Property.class);
		return q.getResultList();
	}
	
	/*****************************************************************************************************************
	 * Method                          fetchPropertyByCriteria
     * Description                     It is used to get all Property from Broker entity which meets the user criteria
	 * @returns List  	               All Properties with given criteria
     * Created By                      Rakshith Vuppala
     * Created Date                    30-MAR-2021                            
	 
	 *****************************************************************************************************************/

	@Override
	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria) {
		String i =criteria.getConfig();
		String j =criteria.getOffer();
		String k =criteria.getCity();
		double l =criteria.getMinCost();
		double m=criteria.getMaxCost();
		if(i ==null)
			i="%";
		if(j==null)
			j="%";
		if(k==null)
			k="%";
		if(m==0)
			m=Double.MAX_VALUE;
			
		TypedQuery<Property> q = em.createQuery("select p from Property p where  p.configuration like :i  and p.offerType like:j and  p.city like :k and (p.offerCost Between :l and :m )", Property.class);
		
		q.setParameter("i", i);
		q.setParameter("j", j);
		q.setParameter("k", k);
		q.setParameter("l", l);
		q.setParameter("m", m);
		return q.getResultList();
	}
}
