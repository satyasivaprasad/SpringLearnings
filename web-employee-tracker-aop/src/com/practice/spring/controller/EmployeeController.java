package com.practice.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.spring.dao.EmployeeDAO;
import com.practice.spring.entity.Employee;
import com.practice.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee using our service
		employeeService.saveEmployee(theEmployee);
		
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Employee theEmployee = employeeService.getEmployee(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("employeeId") int theId) {
		
		// delete the customer
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/list";
	}
}
