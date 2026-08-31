package tw.brad.tutor;

public class Brad33 {

	public static void main(String[] args) {
		System.out.println("Hello, World");
		int a = 10, b = 0;
		try {
			int c = a / b;
			System.out.println(c);
		}catch(ArithmeticException e) {
			System.out.println(".....");
		}
		System.out.println("Finish");
	}

}
