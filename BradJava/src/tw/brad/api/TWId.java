package tw.brad.api;

public class TWId {
	private String id;
	
	public static boolean isRight(String id) {
		boolean isRight = false;
		if (id != null) {
//			if (id.length() == 10) {
//				char c1 = id.charAt(0);
//				String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//				if (letters.indexOf(c1) != -1) {
//					if (id.charAt(1) == '1' ||id.charAt(1) == '2') {
//						
//					}
//				}
//			}
			
			if (id.matches("[A-Z][12][0-9]{8}")) {
				char c1 = id.charAt(0);
				String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
				int a12 = letters.indexOf(c1) + 10;
				//System.out.println(a12);
				int a1 = a12 / 10;
				int a2 = a12 % 10;
				
				
			}
			
			
		}
		return isRight;
	}
	
}
