package com.restapi.service;

import java.util.List;

import com.restapi.entities.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(long id);

	public Employee updateEmployee(Employee employee, long id);

	public void deleteEmployee(long id);

}
