package tw.brad.tutor;

public class Brad24 {

	public static void main(String[] args) {
		Brad241 obj1 = new Brad244();
		Brad241 obj2 = new Brad241() {
			@Override
			public void m1() {
				System.out.println("Brad241:m1()");
			}
			@Override
			public void m2() {
				System.out.println("Brad241:m1()");
			}
		};
		obj2.m1();
		obj2.m2();
	}

}
interface Brad241 {
	void m1();
	void m2();
}
interface Brad242 {
	void m3();
	void m4();
}
interface Brad243 extends Brad241, Brad242 {
	void m5();
}
class Brad244 implements Brad241, Brad242 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	
}
