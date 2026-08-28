package tw.brad.tutor;

import java.util.HashSet;

import tw.brad.api.Bike;

public class Brad25 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("Brad");
		set.add(new Bike());
		set.add(123);	// auto-boxing
		set.add(10.123);	// double -> auto-boxing Double object
		set.add("Brad");
		System.out.println(set);
		
		
		
	}

}
