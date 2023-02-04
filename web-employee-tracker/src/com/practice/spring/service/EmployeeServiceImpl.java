package com.practice.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.spring.dao.EmployeeDAO;
import com.practice.spring.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// need to inject employee dao
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {

		return employeeDAO.getEmployee(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {

		employeeDAO.deleteEmployee(theId);
	}
}
