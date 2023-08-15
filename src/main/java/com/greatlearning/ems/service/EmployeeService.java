package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.model.Employee;

public interface EmployeeService {

	List<Employee> viewAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee findBy(long id);

	Employee updateEmployee(long id, Employee employee);

	void deleteById(long id);

}
