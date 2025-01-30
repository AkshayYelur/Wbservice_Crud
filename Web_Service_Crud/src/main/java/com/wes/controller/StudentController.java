package com.wes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wes.model.Student;
import com.wes.servicei.StudentServiceI;

@RestController
public class StudentController {

	@Autowired
	StudentServiceI si;
	
	@PostMapping("/postStudent")
	public Student saveStudent(@RequestBody Student s)
	{
		si.saveStudent(s);
		return s;
	}
	
	@GetMapping("/getAlldata")
	public List<Student> findAlldata() {
		
		return  si.findAll();
	
	}
	
	@PutMapping("/update/{rollno}")
	public String updateStudent(@PathVariable int rollno, @RequestBody Student s)
	{
		si.saveStudent(s);
		return "Student Updated ...";
	}
	
	@DeleteMapping("/delete/{rollno}")
	public String deleteStudent(@PathVariable int rollno) {
		si.deleteStudent(rollno);
		return "delete";
	}
	
	@GetMapping("/getsingleid/{rollno}")
	public Student getById(@PathVariable("rollno") int rollno) {
		Student s =si.findByRollno(rollno);
		
		return s;
		
	}
	
	@GetMapping("/getname/{name}")
	public Student findByName(@PathVariable("name") String name) {
		Student s = si.findByName(name);
		
		return s ;
	}
	
	@GetMapping("/getcontact/{contact}")
	public Student findByContact(@PathVariable("contact") long contact) {
	
		Student s = si.findByContact(contact);
		
		return s;
		
		
	}
	
	@PatchMapping("/updateName/{rollno}")
	public String updateName(@PathVariable int rollno, @RequestBody Student s)
	{
		si.updateName(rollno, s.getName());
		return "Name updated .....";
	}
	
	@PatchMapping("/updatecontact/{rollno}")
	public String updateContact(@PathVariable int rollno,@RequestBody Student s) {
		
		si.updateContact(rollno, s.getContact());
		return "Contact Updated";
	}
	
	@PatchMapping("/updatemarks/{rollno}")
	public String updateMarks(@PathVariable int rollno,@RequestBody Student s) {
		si.updateMarks(rollno, s.getMarks());
		
		return "marks updated..";
	}
	
	@GetMapping("/matchednames/{name}")
	public List<Student> getMatchedNames(@PathVariable String name) {
		
		
		return si.getByNames(name);
	}
	
}
