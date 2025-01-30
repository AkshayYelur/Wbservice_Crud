package com.wes.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.model.Student;
import com.wes.repository.StudentRepository;
import com.wes.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	StudentRepository sr;
	
	@Override
	public void saveStudent(Student s) {
		
		sr.save(s);
	}

	@Override
	public List<Student> findAll() {
		
		return sr.findAll();
		
	}

	@Override
	public void deleteStudent(int rollno) {
		sr.deleteById(rollno);
		
	}

	@Override
	public Student findByRollno(int rollno) {
		return sr.findByRollno(rollno);
		
	}

	@Override
	public Student findByName(String name) {
		
		return sr.findByName(name) ;
	}

	@Override
	public Student findByContact(long contact) {
	
		return sr.findByContact(contact);
	}

	@Override
	public void updateName(int rollno, String name) {
		
		 sr.updateByName(name, rollno);
	}

	@Override
	public void updateContact(int rollno, long contact) {
		sr.updateByContact(contact, rollno);
		
	}

	@Override
	public void updateMarks(int rollno, double marks) {
		sr.updateByMarks(marks, rollno);
		
	}

	@Override
	public List<Student> getByNames(String name) {
		
		return sr.findAllByName(name);
	}

	

	
	

	

	
}
