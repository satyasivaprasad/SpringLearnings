package com.practice.hibernate.mappings;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Technology;
import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;

public class DeleteTrainerDetailDemo {

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

			// get the trainer detail object
			int theId = 6;
			TrainerDetail trainerDetail = 
					session.get(TrainerDetail.class, theId);
			
			// print the trainer detail
			System.out.println("trainerDetail: " + trainerDetail);
						
			// print  the associated trainer
			System.out.println("the associated trainer: " + 
								trainerDetail.getTrainer());
			
			// now let's delete the trainer detail
			System.out.println("Deleting trainer details: " 
											+ trainerDetail);

			// remove the associated object reference
			// break bi-directional link
			
			trainerDetail.getTrainer().setTrainerDetail(null);
			
			session.delete(trainerDetail);
			
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





