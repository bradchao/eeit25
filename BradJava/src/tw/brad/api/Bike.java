package tw.brad.api;

public class Bike extends Object{
	protected double speed;
	private String color;
	
	public Bike() {
		super();
		System.out.println("Bike()");
		color = "white";
	}
	// Overload
	public Bike(String color) {
		changeColor(color);
	}
	
	
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
