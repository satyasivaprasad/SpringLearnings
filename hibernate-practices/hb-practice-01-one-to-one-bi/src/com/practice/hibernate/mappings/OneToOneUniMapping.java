package com.practice.hibernate.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Trainer;
import com.practice.hibernate.entity.TrainerDetail;

public class OneToOneUniMapping {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainer.class)
				.addAnnotatedClass(TrainerDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			Trainer kTrainer = new Trainer("Krishna", "Patel", "krishna@demo.com");

			TrainerDetail kTrainerDetail = new TrainerDetail("http://www.youtube.com", "10+ Years");

			// associate the objects
			kTrainer.setTrainerDetail(kTrainerDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving trainer: " + kTrainer);
			session.save(kTrainer);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
