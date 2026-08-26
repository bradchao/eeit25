package tw.brad.api;

public class Scooter extends Bike{
	private int gear;

	public Scooter(){
		super("green");
		System.out.println("Scooter()");
	}
	
	
	@Override
	public void upSpeed() {
		//super.upSpeed();
		speed = speed < 1? 1: speed*1.8 * gear;
	}
	
	public void changeGear(int gear) {
		if (gear >= 0 && gear <= 4) {
			this.gear = gear;
		}
	}
}
