package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.model.Department;

@Repository
public interface DeptRepo extends CrudRepository<Department, Integer> {

	@Query("from department d where d.id > ?1")
	List<Department> getRecentDepartmentsList(int deptid);

	@Query(value = "select avg(length(department_name)) from departments", nativeQuery = true)
	int getAvgLength();

	// List<Department> getDepartmentsByLocation (int LocationId)
}
