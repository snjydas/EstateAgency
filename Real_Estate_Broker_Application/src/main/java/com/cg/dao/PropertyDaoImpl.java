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
public class PropertyDaoImpl implements PropertyDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Property> fetchAllProperties() {
		TypedQuery<Property> q=em.createQuery("select p from Property p",Property.class);
		return q.getResultList();
	}

	@Override
	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria) {
		TypedQuery<Property> q=em.createQuery("select p from Property p where p.name like :p",Property.class);
q.setParameter("p", criteria+"%");
return q.getResultList();
	}

//	@Override
//	public Property saveProperty(Property property) {
//		em.persist(property);
//		return property;
//	}
//}
	/*@Override
	public List<Student> createStudent(Student stu) {
		em.persist(stu);
		return getAllStudent();
	}

	@Override
	public List<Student> getAllStudent() {
		TypedQuery<Student> q=em.createQuery("select s from Student s",Student.class);
		return q.getResultList();
	}*/

//	@Override
//	public List<Student> getStudentByName(String name) {
//		
//		TypedQuery<Student> q=em.createQuery("select s from Student s where s.name like :n",Student.class);
//		q.setParameter("n", name+"%");
//		return q.getResultList();
//	}
//
}
