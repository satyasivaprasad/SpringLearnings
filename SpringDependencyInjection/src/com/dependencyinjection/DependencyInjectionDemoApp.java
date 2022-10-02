package com.dependencyinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CricketCoach coach = applicationContext.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println("Team Captain: " + coach.getTeamCaptain());
		System.out.println("Team size: " + coach.getTeamSize());
		applicationContext.close();
	}
}
