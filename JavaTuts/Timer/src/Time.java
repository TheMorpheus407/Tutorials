import java.util.Timer;
import java.util.TimerTask;


public class Time {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		}, 2*1000, 2*1000);
	}

}
