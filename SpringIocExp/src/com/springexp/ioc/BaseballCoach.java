package com.springexp.ioc;

public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend Atleast 30 minutes at ground";
	}

}
