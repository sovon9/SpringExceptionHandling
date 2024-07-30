package com.RestExceptionHandling.handleExcep.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestExceptionHandling.handleExcep.exception.StudentNotFoundException;
import com.RestExceptionHandling.handleExcep.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	List<Student> students;
	
	@PostConstruct
	public void popuateData()
	{
		students = new ArrayList<>();
		students.add(new Student(1, "sovon"));
		students.add(new Student(2, "nawaz"));
		students.add(new Student(3, "dubey"));
		
	}
	
	@GetMapping("/student/{id}")
	public Student findById(@PathVariable int id)
	{
		if(id<0 && id>=students.size())
		{
			throw new StudentNotFoundException("student data not found for id: "+id);
		}
		Optional<Student> findFirst = students.stream().filter(s->s.getId()==id).findFirst();
		if(findFirst.isEmpty())
		{
			throw new StudentNotFoundException("student data not found for id: "+id);
		}
		return findFirst.get();
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student)
	{
		if(null != student)
		{
			students.add(student);
		}
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
	
}
