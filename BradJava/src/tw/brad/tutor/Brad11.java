package tw.brad.tutor;

public class Brad11 {

	public static void main(String[] args) {
		int[] a = new int[3];
		int b = 3;
		System.out.println(a);
		System.out.println(a[0]);
		System.out.println("---");
		
		int[][] ary1 = new int[3][];
		ary1[0] = new int[2];
		ary1[1] = new int[3];
		ary1[2] = new int[4];
		
		for(int[] v : ary1) {
			System.out.println(v);
			for (int vv : v) {
				System.out.print(vv);
			}
			System.out.println();
		}
		
		
	}

}
