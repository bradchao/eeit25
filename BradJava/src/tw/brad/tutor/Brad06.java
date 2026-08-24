package tw.brad.tutor;

import java.util.Scanner;

public class Brad06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Year = ");
		int year = scanner.nextInt();
		//System.out.println(year);
		
		boolean isLeap;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 29
					isLeap = true;
				}else {
					// 28
					isLeap = false;
				}
			}else {
				// 29
				isLeap = true;
			}
		}else {
			// 28
			isLeap = false;
		}
		
		System.out.printf("%d年是%s年", year, isLeap?"潤":"平");
		
		
		
	}

}
