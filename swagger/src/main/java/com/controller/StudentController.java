package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "swagger.Student-Controller")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@ApiOperation(value = "create Student Info")
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student stud) {
		return studentservice.createStudent(stud);

	}

	@GetMapping("/findStudent/{id}")
	@ApiOperation(value = "get student details based on id")
	public Optional<Student> getStudentId(@PathVariable int id) {
		return studentservice.getStudentById(id);
	}

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudent();

	}
	
	@ApiOperation("delete student based on id")
	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudentById(@PathVariable int id) {
		return studentservice.deleteStudentById(id);
	}
}
