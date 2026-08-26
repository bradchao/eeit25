package tw.brad.tutor;

import tw.brad.api.Bike;

public class Brad16 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		Bike b3 = b1;
		String s1 = new String("Brad");
		String s2 = new String("Brad");
		String s3 = "Brad";
		String s4 = "Brad";
		int a = 10, b = 3;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(b1);
		System.out.println(a == b);
		System.out.println(b1 == b3);
		System.out.println(s3 == s4);
		System.out.println("---");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		// 雜湊
		
		
		
		
	}

}
