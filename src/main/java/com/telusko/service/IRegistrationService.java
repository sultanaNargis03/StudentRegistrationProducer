package com.telusko.service;

import com.telusko.model.Student;

public interface IRegistrationService 
{
	public Student registerStudent(Student student);
	public Student getStudentInfo(Integer sid);
	
}
