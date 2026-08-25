package tw.brad.tutor;

public class Brad09 {

	public static void main(String[] args) {
		int p0, p1, p2, p3, p4, p5, p6;
		p0 = p1 = p2 = p3 = p4= p5 = p6 = 0;
		
		int point;
		for (int i=0; i<1000000; i++) {
			point = (int)(Math.random()*6) + 1;	// 1 ~ 6
			
			switch(point) {
				case 1: p1++; break;
				case 2: p2++; break;
				case 3: p3++; break;
				case 4: p4++; break;
				case 5: p5++; break;
				case 6: p6++; break;
				default: p0++; break; 
			}
		}
		
		if (p0 > 0) {
			System.out.println("ERROR!");
		}else {
			System.out.printf("%d點出現%d次\n", 1, p1);
			System.out.printf("%d點出現%d次\n", 2, p2);
			System.out.printf("%d點出現%d次\n", 3, p3);
			System.out.printf("%d點出現%d次\n", 4, p4);
			System.out.printf("%d點出現%d次\n", 5, p5);
			System.out.printf("%d點出現%d次\n", 6, p6);
		}
		
		
		
		
	}

}
