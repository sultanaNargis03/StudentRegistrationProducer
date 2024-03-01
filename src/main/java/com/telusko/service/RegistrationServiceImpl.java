package com.telusko.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telusko.dao.IRegistrationRepo;
import com.telusko.exception.StudentNotFoundException;
import com.telusko.model.Student;

@Service
public class RegistrationServiceImpl implements IRegistrationService 
{

	@Autowired
	private IRegistrationRepo repo;

	@Override
	public Student registerStudent(Student student) 
	{
		
		return repo.save(student);
	}

	@Override
	public Student getStudentInfo(Integer sid) 
	{
		
		return repo.findById(sid).orElseThrow(()->new StudentNotFoundException("Student with "+sid+" not found"));
	}

	
}
