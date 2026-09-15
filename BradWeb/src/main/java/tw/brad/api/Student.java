package tw.brad.api;

public class Student {
	private String name;
	private Bike bike;
	
	public Student(String name) {
		this.name = name;
		bike = new Bike();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	
	
}
