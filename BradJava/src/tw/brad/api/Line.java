package tw.brad.api;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Line implements Serializable{
	private List<Point> points;
	private Color color;
	private float width;
	
	public Line(Color color) {
		points = new ArrayList<>();
		this.color = color;
	}
	
	public void addPoint(int x, int y) {
		Point point = new Point(x, y);
		points.add(point);
	}
	
	public int getX(int index) {
		return points.get(index).getX();
	}
	public int getY(int index) {
		return points.get(index).getY();
	}

	public Color getColor() {
		return color;
	}
	
	public int getSize() {
		return points.size();
	}
	
}
