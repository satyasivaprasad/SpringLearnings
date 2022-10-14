package com.spring.practice;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	String[] randomFortunes = {"Random 1", "Random 2", "Random 3"};
	
	Random random = new Random();
	
	@Override
	public String getDailyFortune() {
		int ranNumber = random.nextInt(randomFortunes.length);
		return randomFortunes[ranNumber];
	}

}
