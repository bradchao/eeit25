package tw.brad.tutor;

import tw.brad.api.Bike;

public class Brad12 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1);
		System.out.println(b1.getSpeed());
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b2.upSpeed();b2.upSpeed();b2.downSpeed();
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		System.out.println("---");
		
		while (b1.getSpeed() < 10) {
			b1.upSpeed();
		}
		
		System.out.println(b1.getSpeed());
	
	}

}
