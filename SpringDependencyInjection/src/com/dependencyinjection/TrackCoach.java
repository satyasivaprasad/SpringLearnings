package com.dependencyinjection;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run Atleat 5km";
	}

	@Override
	public String getDailyFortune() {
		return "Hello man! " + fortuneService.getFortune();
				
	}
		
}
