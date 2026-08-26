package tw.brad.tutor;

public class Brad19 {
	public static void main(String[] args) {
		//Brad191 obj1 = new Brad191();
		//Brad192 obj2 = new Brad192();
		Brad193 obj3 = new Brad193("ok");
	}
}
class Brad191 extends Object{
	Brad191(){
		System.out.println("Brad191()");
	}
}
class Brad192 extends Brad191 {
	Brad192(){
		// super()
		System.out.println("Brad192()");
	}
	Brad192(int a){
		// super()
		System.out.println("Brad192(int)");
	}
}
class Brad193 extends Brad192 {
	Brad193(){
		System.out.println("Brad193()");
	}
	Brad193(int a){
		this();
		System.out.println("Brad193(int)");
	}
	Brad193(String b){
		this(1);
		System.out.println("Brad193(String)");
	}
}
