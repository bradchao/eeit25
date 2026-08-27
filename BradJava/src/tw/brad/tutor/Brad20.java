package tw.brad.tutor;

import tw.brad.api.TWId;

public class Brad20 {

	public static void main(String[] args) {
		TWId id = TWId.newTWId("A123456789");
		if (id != null) {
			System.out.println(id);
			System.out.println(id.isMale()?"male":"female");
			System.out.println(id.getArea());
		}
	}

}
