package com.telusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.generator.UUIDGenarator;
import com.telusko.model.AdmitCard;
import com.telusko.model.RegCard;
import com.telusko.model.Student;
import com.telusko.service.RegistrationServiceImpl;

@RestController
@RequestMapping("/registration")
public class RegistrationController 
{
	@Autowired
	RegistrationServiceImpl service;
	
	@PostMapping("/getRegNo")
	public ResponseEntity<RegCard> enrollStudents(@RequestBody Student student)
	{
		Student std = service.registerStudent(student);
		RegCard reg=new RegCard();
		reg.setRegNum(std.getSid());
		
		return new ResponseEntity<RegCard>(reg,HttpStatus.OK);
	}
	
	@GetMapping("/getRegCard/{regNum}")
	public ResponseEntity<RegCard> getRegCard(@PathVariable Integer regNum)
	{
		Student student = service.getStudentInfo(regNum);
		RegCard reg=new RegCard();
		reg.setRegNum(student.getSid());
		reg.setSname(student.getSname());
		reg.setBoardName(student.getBoardName());
		reg.setDob(student.getDob());
		reg.setInstituteName(student.getInstituteName());
		reg.setYearOfReg(student.getYearOfReg());
		return new ResponseEntity<RegCard>(reg,HttpStatus.OK);
		
	}
	@GetMapping("/getAdmitCard/{regNum}")
	public ResponseEntity<AdmitCard> getAdmitCard(@PathVariable Integer regNum)
	{
		UUIDGenarator uuid=new UUIDGenarator();
		Student student = service.getStudentInfo(regNum);
		AdmitCard admit=new AdmitCard();
		admit.setRegNum(student.getSid());
		admit.setSname(student.getSname());
		admit.setRollNo(uuid.generateUUID());
		admit.setDepartment(student.getDepartment());
		admit.setBoardName(student.getBoardName());
		admit.setDob(student.getDob());
		admit.setInstituteName(student.getInstituteName());
		admit.setYearOfReg(student.getYearOfReg());
		return new ResponseEntity<AdmitCard>(admit,HttpStatus.OK);
		
	}
}
