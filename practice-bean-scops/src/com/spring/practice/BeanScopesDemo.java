package com.spring.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopesDemo {
	public static void main(String[] args) {
		// load the spring configuration file
				ClassPathXmlApplicationContext context =
						new ClassPathXmlApplicationContext("bean-practice-applicationContext.xml");
						
				// retrieve bean from spring container
				Coach theCoach = context.getBean("myGolfCoach", Coach.class);

				Coach alphaCoach = context.getBean("myGolfCoach", Coach.class);
				
				// check if they are the same
				boolean result = (theCoach == alphaCoach);
				
				System.out.println("\nPointing to the same object: " + theCoach.getDailyFortune());
				
				// print out the results
				System.out.println("\nPointing to the same object: " + result);
				
				System.out.println("\nMemory location for theCoach: " + theCoach);

				System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
			
				// close the context
				context.close();
	}
}
