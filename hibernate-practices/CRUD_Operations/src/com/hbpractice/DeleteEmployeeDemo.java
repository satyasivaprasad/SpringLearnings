package com.hbpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbpractice.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
			int employeeId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting Employee with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// delete the employee
			// System.out.println("Deleting employee: " + myemployee);
			// session.delete(myemployee);
			
			// delete employee id=1
			System.out.println("Deleting Employee id=1");
			
			session.createQuery("delete from Employee where id=1").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





