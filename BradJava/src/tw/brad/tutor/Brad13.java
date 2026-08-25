package tw.brad.tutor;

import tw.brad.api.Bike;
import tw.brad.api.Scooter;

public class Brad13 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Scooter s1 = new Scooter();
		s1.changeGear(2);
		s1.upSpeed(); s1.upSpeed();
		s1.upSpeed(); s1.upSpeed();
		System.out.println(s1.getSpeed());
	}

}
