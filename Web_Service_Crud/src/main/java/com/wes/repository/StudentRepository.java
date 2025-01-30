package com.wes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wes.model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {


	public Student findByRollno(int rollno);
	
	public Student findByName(String name);

	public Student findByContact(long contact);
	
	@Transactional
	@Modifying
	@Query("update Student set name=:sn where rollno=:rn")
	public void updateByName(@Param("sn") String name, @Param("rn")int rollno);
	
	@Transactional
	@Modifying
	@Query("update Student set contact=:ct where rollno=:rn")
	public void updateByContact(@Param("ct") long contact , @Param("rn") int rollno);
	
	@Transactional
	@Modifying
	@Query("update Student set marks=:ms where rollno=:rn")
	public void updateByMarks(@Param("ms") double marks,@Param("rn") int rollno);
	
	
	List<Student> findAllByName(String name);
	
}
