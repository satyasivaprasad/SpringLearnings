package com.practice.hibernate.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Technology;
import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;

public class DeleteTechnologyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Trainer.class)
								.addAnnotatedClass(TrainerDetail.class)
								.addAnnotatedClass(Technology.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get a technology
			int theId = 12;
			Technology technology = session.get(Technology.class, theId);
			
			// delete technology
			System.out.println("Deleting technology: " + technology);
			
			session.delete(technology);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





