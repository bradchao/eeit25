package tw.brad.tutor;

public class Brad06 {

	public static void main(String[] args) {
		
		int year = 2026;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 29
				}else {
					// 28
				}
			}else {
				// 29
			}
		}else {
			// 28
		}
		
		
		
	}

}
