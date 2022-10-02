package com.dependencyinjection;

public class LuckyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is lucky fortune service";
	}

}
