package tw.brad.tutor;

public class PokerV3 {

	public static void main(String[] args) {
		int[] poker = new int[10];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i=0; i<poker.length; i++) {
			int rIndex = (int)(Math.random()*10);
			// poker[i] <-> poker[rIndex]
			int temp = poker[i];
			poker[i] = poker[rIndex];
			poker[rIndex] = temp; 
		}
		for (int card :poker) {
			System.out.println(card);
		}
	}

}
