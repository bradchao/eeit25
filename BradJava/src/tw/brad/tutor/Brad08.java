package tw.brad.tutor;

public class Brad08 {

	public static void main(String[] args) {
		int[] ary;
		ary = new int[3];
		for (int i = 0; i<ary.length; i++) {
			System.out.println(ary[i]);
		}
		System.out.println("---");
		ary[0] = 123;
		ary[1] = 77;
		//ary[1000] = 12;	// +int
		System.out.println(ary[0]);
		System.out.println("---");
		for (int v : ary) {	// for-each
			System.out.println(v);
		}
	}

}
