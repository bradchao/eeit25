package tw.brad.tutor;

public class Brad23 {
	public static void main(String[] args) {
		Brad231 obj1 = new Brad231();
		Brad231 obj2 = new Brad231();
		Brad231 obj3 = new Brad231();
//		obj1.m1();
		
		//Brad231.m2();
		System.out.println(Brad231.i);
		System.out.println(obj1.j);
	}
}
class Brad231 {
	static int i;
	int j;
	
	{System.out.println("Brad231:{}" + j);}
	static {System.out.println("Brad231:static{}");}
	
	Brad231(){i++; j++; System.out.println("Brad231()");}
	
	void m1() {System.out.println("Brad231:m1()");}
	
	static void m2() {System.out.println("Brad231:static m2()");}
}
