package com.telusko.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.model.Student;

@Repository
public interface IRegistrationRepo extends JpaRepository<Student, Integer> 
{
	
}
