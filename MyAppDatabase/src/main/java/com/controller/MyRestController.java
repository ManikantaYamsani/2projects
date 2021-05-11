package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dao.DeptRepo;
import com.model.Department;

@RestController
@RequestMapping("/rest/add")
public class MyRestController {

	@Autowired
	DeptRepo deptRepo;

	@GetMapping() // for http get request
	public Iterable<Department> grtAllDept() {
		return deptRepo.findAll();

	}

	@GetMapping("/{id}") // for http get request with id
	public Department getOneDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptRepo.findById(id);
		if (dept.isPresent())
			return dept.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department id not found");
	}

	@PostMapping() // for http post request
	public Department addDept(Department dept) {
		try {

			// if so, throw exception
			deptRepo.save(dept);
			return dept;
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
		}
	}

	@DeleteMapping("/{id}") // for HTTP DELETE request
	public void deleteDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptRepo.findById(id);
		if (dept.isPresent()) {
			try {
				deptRepo.delete(dept.get());
			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department Id Not Found:");
		}
	}

	@PutMapping("/{id}") // For HTTP put request
	public void UpdateDept(@PathVariable("id") int id, Department newDept) {
		Optional<Department> dept = deptRepo.findById(id);
		if (dept.isPresent()) {
			try {
				Department dbDept = dept.get();
				dbDept.setName(newDept.getName());
				deptRepo.save(dbDept);

			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Department Id NOt Found");
		}
	}
}
