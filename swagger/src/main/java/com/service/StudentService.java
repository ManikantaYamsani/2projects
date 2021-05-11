package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentRepo;
import com.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentrepo;

	public Student createStudent(Student stud) {
		return studentrepo.save(stud);
	}

	public Optional<Student> getStudentById(int id) {
		return studentrepo.findById(id);
	}

	public List<Student> getAllStudent() {

		return studentrepo.findAll();
	}

	public String deleteStudentById(int id) {
		studentrepo.deleteById(id);
		return "deleted" + id;
	}
}
