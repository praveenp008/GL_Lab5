package com.greatlearning.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> viewAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findBy(long id) {
		return employeeRepository.findById(id).orElseThrow();
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Optional<Employee> findById = this.employeeRepository.findById(id);
		if (findById.isPresent()) {
			Employee employee2 = findById.get();
			employee2.setFirstName(employee.getFirstName());
			employee2.setId(employee.getId());
			employee2.setLastName(employee.getLastName());
			employee2.setEmail(employee.getEmail());
			employeeRepository.save(employee2);
		}
		return employee;

	}

	@Override
	public void deleteById(long id) {
		employeeRepository.deleteById(id);

	}

}
