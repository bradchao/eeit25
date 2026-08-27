package tw.brad.tutor;

public class Brad21 {
	public static void main(String[] args) {
		Brad212 obj1 = new Brad212();
		
		Brad212 obj2 = new Brad213();
		obj2.m1(); obj2.m2();
		//obj2.m3();
		
		Brad213 obj3 = (Brad213)obj2;
		obj3.m3();
		
		if (obj1 instanceof Brad213) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
			//Brad213 obj4 = (Brad213)obj1;
		}
		System.out.println("---1");
		Brad211 obj5 = new Brad214();
		obj5.m1();
		//Brad212 obj6 = (Brad212)obj5;
		System.out.println("-----2");
		go(obj1);go(obj2);go(obj3);
	}
	
	static void go(Brad212 obj1) {
		obj1.m2();
	}
}
class Brad211 {
	Brad211(){System.out.println("Brad211");}
	void m1() {System.out.println("Brad211:m1()");}
}
class Brad212 extends Brad211 {
	Brad212(){System.out.println("Brad212");}
	void m2() {System.out.println("Brad212:m2()");}
}
class Brad213 extends Brad212 {
	Brad213(){System.out.println("Brad213");}
	void m2() {System.out.println("Brad213:m2()");}
	void m3() {System.out.println("Brad213:m3()");}
}
class Brad214 extends Brad211 {
	Brad214(){System.out.println("Brad214");}
	
}
