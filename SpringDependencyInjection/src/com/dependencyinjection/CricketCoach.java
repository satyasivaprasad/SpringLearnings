/**
 * 
 */
package com.dependencyinjection;

/**
 * @author siva
 *
 */
public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String teamCaptain;
	public String getTeamCaptain() {
		return teamCaptain;
	}

	public void setTeamCaptain(String teamCaptain) {
		this.teamCaptain = teamCaptain;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	private int teamSize;
	
	public CricketCoach() {
		System.out.println("CricketCoach: Inside default constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice for 2 hours";
	}

	@Override
	public String getDailyFortune() {
		return "Hey whats up! " + fortuneService.getFortune();
	}

}
