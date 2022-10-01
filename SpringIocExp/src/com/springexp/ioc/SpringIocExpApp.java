package com.springexp.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocExpApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach myCoach = appContext.getBean("myCoach", Coach.class);
		System.out.println(myCoach.getDailyWorkout());
		appContext.close();
	}
}
