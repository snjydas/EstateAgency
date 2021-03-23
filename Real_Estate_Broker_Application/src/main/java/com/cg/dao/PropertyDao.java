package com.cg.dao;

import java.util.List;

import com.cg.entity.Property;

public interface PropertyDao {
	/*public List<Student> createStudent(Student stu);
	public List<Student> getAllStudent();*/
	//public List<Student> getStudentByName(String name);
	
	public List<Property> fetchAllProperties();
}
