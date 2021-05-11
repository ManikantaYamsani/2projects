package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "department_id")
	private int id;
	@Size(min = 4, max = 20, message = "department name must be 4-20 chars")
	@Column(name = "department_name")
	private String name;

	public Department() {
		super();
	}

	public Department(int id, @Size(min = 4, max = 20, message = "department name must be 4-20 chars") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
