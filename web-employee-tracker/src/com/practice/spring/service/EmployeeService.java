package com.practice.spring.service;

import java.util.List;

import com.practice.spring.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
}
