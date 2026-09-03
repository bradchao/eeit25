package tw.brad.api;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel{
	private Timer timer;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
	
	public MyClock() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				LocalTime now = LocalTime.now();
				setText(now.format(formatter));
			}
		}, 0, 100);
	}
}
