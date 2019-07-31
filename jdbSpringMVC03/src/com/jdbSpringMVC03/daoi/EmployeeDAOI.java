package com.jdbSpringMVC03.daoi;

import java.util.List;

import com.jdbSpringMVC03.entities.Employee;

public interface EmployeeDAOI {

	boolean addEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	boolean removeEmployeeByIdService(int id);
	boolean updatedEmployee(Employee emp);

}
