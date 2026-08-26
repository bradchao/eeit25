package tw.brad.tutor;

import tw.brad.api.Bike;
import tw.brad.api.Scooter;

public class Brad14 {

	public static void main(String[] args) {
		Bike bike = new Bike();
		Bike mybike = new Bike("red");
		Bike urbike = new Bike("yellow");
		
		System.out.println(bike.getSpeed());
		System.out.println(bike.getColor());
		System.out.println(mybike.getColor());
		System.out.println(urbike.getColor());
		System.out.println("---");
		Scooter s1 = new Scooter();
	}

}
