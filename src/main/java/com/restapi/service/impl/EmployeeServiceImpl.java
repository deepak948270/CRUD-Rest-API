package com.restapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Employee;
import com.restapi.repository.EmployeeRepository;
import com.restapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);

	}

	@Override
	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
		
		// return employeeRepository.findById(id).get();

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		if (existingEmployee.isPresent()) {
			Employee updateEmployee = existingEmployee.get();
			updateEmployee.setFirstName(employee.getFirstName());
			updateEmployee.setLastName(employee.getLastName());
			updateEmployee.setEmailId(employee.getEmailId());
			employeeRepository.save(updateEmployee);

		}
		return null;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);

	}

}
