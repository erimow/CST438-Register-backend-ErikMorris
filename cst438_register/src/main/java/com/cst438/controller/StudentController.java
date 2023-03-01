package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.CourseRepository;
import com.cst438.domain.EnrollmentRepository;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;
import com.cst438.service.GradebookService;


@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://registerf-cst438.herokuapp.com/"})
public class StudentController 
{
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	GradebookService gradebookService;
	
	//@GetMapping("/student/")
	public Student getStudent() {
		
		return null;
	}
	
	@PostMapping("/student/add")
	@Transactional
	public Student addStudent( @RequestParam("email") String email, @RequestParam("name") String name)
	{
		System.out.println("/student/add called.");
		if (email.equals(studentRepository.findByEmail(email).getEmail()))
		{
			return null;
		}
		else
		{
			Student newStud = new Student();
			newStud.setName(name);
			newStud.setName(email);
			//newStud.setStudent_id();
			System.out.println(name);
			return newStud;
		}
		
		
	}
	

}
