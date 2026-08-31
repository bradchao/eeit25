package tw.brad.tutor;

import java.util.HashSet;
import java.util.Set;

import tw.brad.api.Bike;

public class Brad31 {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		String s1 = "Brad";
		String s2 = "Brad";
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		names.add(s1);names.add(s2);names.add(s3);names.add(s4);
		System.out.println(names.size());
		
		Set<Bike> bikes = new HashSet<>();
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		Bike b3 = new Bike();
		Bike b4 = new Bike();
		bikes.add(b1);bikes.add(b2);bikes.add(b3);bikes.add(b4);
		System.out.println(bikes.size());
		
		
		
		
	}

}
