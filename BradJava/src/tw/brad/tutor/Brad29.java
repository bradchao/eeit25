package tw.brad.tutor;

import java.util.HashMap;
import java.util.Map;

import tw.brad.api.Bike;

public class Brad29 {

	public static void main(String[] args) {
		Map<String,Object> person = new HashMap<>();
		person.put("name", "Brad");
		person.put("age", 18);
		person.put("gender", true);
		person.put("bike", new Bike());
		System.out.println(person.get("name"));
		System.out.println(person);
		
		Map<String,Integer> point = new HashMap<>();
		point.put("x", 10); point.put("y", 123);
		System.out.println(point);
		
		
	}

}
