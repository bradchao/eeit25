package tw.brad.api;

public class Bike {
	protected double speed;
	private String color;
	
	public void changeColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
	public void upSpeed() {
		speed = speed < 1? 1: speed*1.4; 
	}
	
	public void downSpeed() {
		speed = speed < 1? 0: speed*0.7;
	}
	
	public double getSpeed() {
		return speed;
	}
}
