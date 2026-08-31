package tw.brad.tutor;

public class Brad28 {
	public static void main(String[] args) {
		Brad281 obj1 = new Brad282();
		Brad281 obj2 = new Brad283();
		Brad281 obj3 = new Brad281() {
			@Override
			void m2() {
				System.out.println("Brad281:m2()");
			}
		};
		obj1.m1(); obj2.m1(); obj3.m1();
		obj1.m2(); obj2.m2(); obj3.m2();
	}
}

abstract class Brad281 {
	void m1() {System.out.println("Brad281:m1()");}
	abstract void m2();
}
class Brad282 extends Brad281 {
	@Override
	void m2() {System.out.println("Brad282:m2()");}
}
class Brad283 extends Brad281 {
	@Override
	void m2() {System.out.println("Brad283:m2()");}
}

