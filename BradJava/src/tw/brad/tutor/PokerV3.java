package tw.brad.tutor;

public class PokerV3 {

	public static void main(String[] args) {
		int[] poker = new int[52];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i=0; i<poker.length; i++) {
			int rIndex = (int)(Math.random()*52);
			// poker[i] <-> poker[rIndex]
			int temp = poker[i];
			poker[i] = poker[rIndex];
			poker[rIndex] = temp; 
		}
//		for (int card :poker) {
//			System.out.println(card);
//		}
//		System.out.println("---");
		//---------------------------
		int[][] players = new int[4][13];
		for (int i=0; i<poker.length; i++) {
			players[i%4][i/4] = poker[i];
		}
		
		for (int[] player: players) {
			for (int card : player) {
				System.out.print(card + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
	}

}
