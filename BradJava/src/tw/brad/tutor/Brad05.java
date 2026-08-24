package tw.brad.tutor;

public class Brad05 {

	public static void main(String[] args) {
		double temp = Math.random();
		int score = (int)(temp * 101);
		System.out.println(score);
		if (score >= 60) {
			System.out.println("Pass");
		}else {
			System.out.println("Down");
		}
	}

}
