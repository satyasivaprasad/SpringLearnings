package com.practice.hibernate.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Technology;
import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;

public class CreateTechnologiesDemo {


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
			
			// get the trainer from db
			int theId = 6;
			Trainer trainer = session.get(Trainer.class, theId);		
			
			// create some technologies		
			Technology nodeTechnology = new Technology("Node");
			
			// add technologies to trainer
			trainer.add(nodeTechnology);
			
			// save the technologies
			session.save(nodeTechnology);
			
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
