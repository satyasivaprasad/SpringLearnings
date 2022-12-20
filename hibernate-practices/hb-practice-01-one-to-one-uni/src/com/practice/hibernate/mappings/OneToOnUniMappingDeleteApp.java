package com.practice.hibernate.mappings;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;

public class OneToOnUniMappingDeleteApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Trainer.class)
								.addAnnotatedClass(TrainerDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 1;
			Trainer tempTrainer = 
					session.get(Trainer.class, theId);
			
			System.out.println("Found trainer: " + tempTrainer);
			
			// delete the instructors
			if (tempTrainer != null) {
			
				System.out.println("Deleting: " + tempTrainer);
				
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL
				//
				session.delete(tempTrainer);				
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





