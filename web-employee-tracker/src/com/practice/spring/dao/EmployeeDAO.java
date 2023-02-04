package  com.practice.spring.dao;

import java.util.List;

import com.practice.spring.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee theEmployee);
	
	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
	
	
}
