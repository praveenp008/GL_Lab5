package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.model.Employee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String viewAllEmployees(Model model) {
		List<Employee> viewAllEmployees = this.employeeService.viewAllEmployees();
		model.addAttribute("employees", viewAllEmployees);
		return "employee/list-employees";
	}

	@PostMapping("/save")
	public String saveEmployees(Model model, @ModelAttribute("employee") Employee employee) {
		this.employeeService.saveEmployee(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		model.addAttribute("employee", theEmployee);
		return "employee/employee-form";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		this.employeeService.deleteById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Employee theEmp = employeeService.findBy(id);
		model.addAttribute("employee", theEmp);
		return "employee/employee-form";
	}

}
