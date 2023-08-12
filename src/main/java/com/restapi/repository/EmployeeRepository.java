package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entities.Employee;

// don't need to use @Repository because JpaRepository will take care of it 

public interface EmployeeRepository  extends JpaRepository<Employee,Long>{

}
