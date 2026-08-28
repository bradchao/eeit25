package tw.brad.tutor;

public class Brad22 {
	public static void main(String[] args) {
		Brad222 obj1 = new Brad222();
		Brad221 obj2 = new Brad222();
		Brad221 obj3 = new Brad223();
		go(obj2); go(obj3);
	}
	
	static void go(Brad221 obj) {
		obj.m1();
		obj.m2(3);
	}
	
}
interface Brad221 {		// public 
	void m1();
	void m2(int a);
}
class Brad222 implements Brad221{
	@Override
	public void m1() {System.out.println("Brad222:m1()");}
	@Override
	public void m2(int a) {
		System.out.println("Brad222:m2(int)");
	}
	public void m3() {System.out.println("Brad222:m3()");}
}
class Brad223 implements Brad221{
	@Override
	public void m1() {System.out.println("Brad223:m1()");}
	@Override
	public void m2(int a) {
		System.out.println("Brad223:m2(int)");
	}
	public void m4() {System.out.println("Brad223:m4()");}
}
