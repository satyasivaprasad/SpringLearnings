package firstspringdemo;

public class IoCApp {
	
	public static void main(String[] args) {
		Coach ch = new TrackCoach();
		System.out.print(ch.getDailyWorkout());
	}

}
