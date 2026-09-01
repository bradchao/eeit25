package tw.brad.tutor;

public class Brad33 {

	public static void main(String[] args) {
		System.out.println("Hello, World");
		int a = 10, b = 3;
		int[] d = {1,2,3,4};
		try {
			int c = a / b;
			System.out.println(c);
			System.out.println(d[4]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(".....2");
		}catch(ArithmeticException e) {
			System.out.println(".....1");
		}catch(RuntimeException e) {
			System.out.println(".....3");
		}
		System.out.println("Finish");
	}

}
