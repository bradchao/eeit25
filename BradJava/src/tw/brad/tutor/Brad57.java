package tw.brad.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad57 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask myTask = new MyTask();
		StopTask stopTask = new StopTask(timer);
		timer.schedule(myTask, 1*1000, 100);
		timer.schedule(stopTask, 10*1000);
		System.out.println("Main");
	}
}

class MyTask extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}

class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {this.timer = timer;}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}


