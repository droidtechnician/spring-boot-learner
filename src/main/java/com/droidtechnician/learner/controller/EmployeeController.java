package com.droidtechnician.learner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.droidtechnician.learner.entities.Employee;
import com.droidtechnician.learner.repositories.EmployeeRepository;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		Iterable<Employee> employeeItr =  employeeRepo.findAll();
		List<Employee> employeeList = new ArrayList<Employee>();
		for (Employee employee: employeeItr) {
			employeeList.add(employee);
		}
		
		return employeeList;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id ) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if (optionalEmployee.isPresent()) 
				return ResponseEntity.ok(optionalEmployee.get());
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			return ResponseEntity.ok(employeeRepo.save(employee));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
		try {
			employeeRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
