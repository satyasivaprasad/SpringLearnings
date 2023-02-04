package com.practice.hibernate.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Technology;
import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;


public class CreateTrainerDemo {

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
			
			// create the objects			
			Trainer trainer = 
					new Trainer("satya", "fission", "sf@gmail.com");
			
			TrainerDetail trainerDetails =
					new TrainerDetail(
							"http://www.youtube.com",
							"18+ Years");		
			
			// associate the objects
			trainer.setTrainerDetail(trainerDetails);
			
			
			Trainer trainer1 = 
					new Trainer("Ram", "Chandra", "rc@gmail.com");
			
			TrainerDetail trainerDetails1 =
					new TrainerDetail(
							"http://www.youtube.com",
							"15+ Years");		
			
			// associate the objects
			trainer1.setTrainerDetail(trainerDetails1);
			
			
			Trainer trainer2 = 
					new Trainer("Krishna", "Battu", "kb@gmail.com");
			
			TrainerDetail trainerDetails2 =
					new TrainerDetail(
							"http://www.youtube.com",
							"12+ Years");		
			
			// associate the objects
			trainer2.setTrainerDetail(trainerDetails2);
			
			// start a transaction
			session.beginTransaction();
			
			// save the trainer
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving trainer: " + trainer);
			session.save(trainer);	
			session.save(trainer1);	
			session.save(trainer2);	
			
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





