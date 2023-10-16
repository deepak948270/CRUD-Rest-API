package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.Employee;
import com.restapi.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

@Tag(name = "Employee")
@SecurityRequirement(name = "thapak-auth")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Operation(summary = "get all the employees", description = "this endpoint returns all the employees")

	// RestApi for getting all Employees
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/getemployees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@Operation(summary = "get employee corresponding to the id", description = "this endpoint return the employee to the corresponding employee id ")

	// RestApi for getting Employee by Id
	@GetMapping("/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return employeeService.getEmployeeById(id);
	}

	@Operation(summary = "save the single emloyee", description = "it save the employee to the database and return the saved employee")

	// RestApi for creating the Employee
	@PostMapping("/saveemployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@Operation(summary = "update the employee corresponding to the id ", description = "this endpoint just update the employee by corresponding to the employee id ")

	// RestApi for updating the Employee
	@PutMapping("/updateemployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
		return employeeService.updateEmployee(employee, id);

	}

	@Operation(summary = "delete the employee corresponding to the id", description = "this endpoint simply delete the employee corresponding to the employee id")

	// RestApi for deleting the Employee
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

}
