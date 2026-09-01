package tw.brad.tutor;

public class Brad35 {
	public static void main(String[] args) {
		try {
			new Brad351().m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Brad351 {
	void m1() throws Exception{
		m2();
	}
	void m2() throws Exception{
		m3();
	}
	void m3() throws Exception{
		throw new Exception();
	}
}
