package com.droidtechnician.learner.repositories;

import org.springframework.data.repository.CrudRepository;

import com.droidtechnician.learner.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
