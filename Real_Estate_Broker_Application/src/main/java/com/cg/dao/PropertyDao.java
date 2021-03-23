package com.cg.dao;

import java.util.List;

import com.cg.entity.Property;
import com.cg.pojo.PropertyCriteria;

public interface PropertyDao {
	/*public List<Student> createStudent(Student stu);
	public List<Student> getAllStudent();*/
	//public List<Student> getStudentByName(String name);
	
//	public Property saveProperty(Property property);
	public List<Property> fetchAllProperties();
	public List<Property> fetchPropertyByCriteria(PropertyCriteria criteria);
}
