package tw.brad.tutor;

import java.security.GeneralSecurityException;

public class Brad34 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(2);
		} catch (GeneralSecurityException e) {
			System.out.println("ERR");
		}
	}

}
class Bird {
	int leg;
	
	void setLeg(int n) throws GeneralSecurityException{
		if (n >= 0 && n <= 2) {
			leg = n;
		}else {
			throw new GeneralSecurityException();
		}
	}
}
