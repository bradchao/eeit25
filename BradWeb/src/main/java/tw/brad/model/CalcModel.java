package tw.brad.model;

public class CalcModel {
	private int x, y;
	public CalcModel(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public String plus() {
		return x + y + "";
	}
}
