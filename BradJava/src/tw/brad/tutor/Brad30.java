package tw.brad.tutor;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Brad30 {

	public static void main(String[] args) {
		Set<String> names = Set.of("Brad","Peter","Tony","Mark");
		System.out.println(names);
		List<String> list = List.of("Brad","Peter","Tony","Mark");
		System.out.println(list);
		Map<Integer,String> maps = Map.of(1,"Brad", 7, "Peter", 4, "Tony", 100, "Mark");
		System.out.println(maps);
	}

}
