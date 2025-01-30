package com.wes.servicei;

import java.util.List;

import com.wes.model.Student;

public interface StudentServiceI {

	public void saveStudent(Student s);
	
	public List<Student>  findAll();
	
	public void deleteStudent(int rollno);
	
	public Student findByRollno(int rollno);
	
	public Student findByName(String name);

	public Student findByContact(long contact);
	
	public void updateName(int rollno, String name);
	
	public void updateContact(int rollno,long contact);
	
	public void updateMarks(int rollno,double marks);
	
	public List<Student> getByNames(String name);
	
	
}
