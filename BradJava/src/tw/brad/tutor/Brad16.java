package tw.brad.tutor;

import tw.brad.api.Bike;

public class Brad16 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		String s1 = new String("Brad");
		String s2 = new String("Brad");
		String s3 = "Brad";
		String s4 = "Brad";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(b1);
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
	}

}
