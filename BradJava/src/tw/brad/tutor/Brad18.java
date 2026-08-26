package tw.brad.tutor;

import tw.brad.api.TWId;

public class Brad18 {

	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(TWId.isRight("L107618050"));
		
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId('S');
		TWId id4 = new TWId(true, 'B');
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
	}

}
