package tw.brad.tutor;

public class Brad10 {

	public static void main(String[] args) {
		int[] p = new int[7];	// p[0]=0, p[1]=0
		
		int point;
		for (int i=0; i<10000000; i++) {
			point = (int)(Math.random()*9) + 1;	// 1 ~ 6
			
			if (point >=1 && point <=9 ) {
				p[point>=7?point-3:point]++;
			}else {
				p[0]++;
			}
		}
		
		if (p[0] > 0) {
			System.out.println("ERROR!");
		}else {
			for(int i=1; i<p.length; i++) {
				System.out.printf("%d點出現%d次\n", i, p[i]);
			}
		}
	}

}
