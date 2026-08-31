package tw.brad.tutor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Brad26 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery = new TreeSet<>();
		//System.out.println(lottery.size());
		while (lottery.size() < 6) {
			lottery.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery);
		
		for (Integer i : lottery) {
			System.out.println(i);
		}
		System.out.println("----");
		
		Iterator<Integer> iterator =  lottery.iterator();
		while (iterator.hasNext()) {
			Integer v = iterator.next();
			System.out.println(v);
		}
		
		
		
		
	}

}
