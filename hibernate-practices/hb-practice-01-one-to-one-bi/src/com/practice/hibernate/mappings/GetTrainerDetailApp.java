package com.practice.hibernate.mappings;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;

public class GetTrainerDetailApp {

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

			// get the trainer detail object
			int theId = 3;
			TrainerDetail tempTrainerDetail = 
					session.get(TrainerDetail.class, theId);
			
			// print the trainer detail
			System.out.println("tempTrainerDetail: " + tempTrainerDetail);
						
			// print  the associated trainer
			System.out.println("the associated trainer: " + 
								tempTrainerDetail.getTrainer());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}





