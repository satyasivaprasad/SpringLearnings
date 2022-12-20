package com.hbpractice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbpractice.entity.Employee;

public class QueryEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query Employees
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			// display the Employees
			displayEmployees(theEmployees);
			
			// query Employees: lastName='Battu'
			theEmployees = session.createQuery("from Employee s where s.lastName='Battu'").getResultList();
			
			// display the Employees
			System.out.println("\n\nEmployees who have last name of Battu");
			displayEmployees(theEmployees);
			
			// query Employees: lastName='Krishna' OR firstName='Battu'
			theEmployees =
					session.createQuery("from Employee s where"
							+ " s.lastName='Krishna' OR s.firstName='Battu'").getResultList();
			
			System.out.println("\n\nEmployees who have last name of Doe OR first name Daffy");
			displayEmployees(theEmployees);
			
			// query Employees where email LIKE '%gmail.com'
			theEmployees = session.createQuery("from Employee s where"
					+ " s.email LIKE '%gmail.com'").getResultList();

			System.out.println("\n\nEmployees whose email ends with gmail.com");			
			displayEmployees(theEmployees);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}





