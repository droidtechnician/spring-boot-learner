package com.droidtechnician.learner.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {

//	@TableGenerator(name="employee_gen", table = "id_gen",pkColumnName = "gen_name", 
//			valueColumnName = "gen_val", pkColumnValue = "employee", allocationSize = 100)
	@GenericGenerator(name = "emp_id", strategy = "com.droidtechnician.learner.idgenerators.EmployeeIdGenerator")
	@Id
	@GeneratedValue(generator="emp_id")
	private Long id;

	private String name;

	public Employee() {
	}

	public Employee(Long id, String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
