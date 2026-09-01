package tw.brad.api;

import java.io.Serializable;

public class Student implements Serializable{
	private int ch, eng, math;
	private String name;
	private Bike bike;
	
	public Student(int ch, int eng, int math, String name) {
		super();
		this.ch = ch;
		this.eng = eng;
		this.math = math;
		this.name = name;
		bike = new Bike();
	}
	
	public int sum() {return ch + eng + math;}
	public double avg() {return sum() / 3.0;}

	public int getCh() {
		return ch;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public String getName() {
		return name;
	}

	public Bike getBike() {
		return bike;
	}
	
	
	
}
