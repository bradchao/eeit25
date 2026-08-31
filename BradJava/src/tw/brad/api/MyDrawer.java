package tw.brad.api;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	private ArrayList<Line> lines, recycler;
	private Color nowColor;
	
	
	public MyDrawer() {
		lines = new ArrayList<>();
		recycler = new ArrayList<>();
		
		setBackground(Color.YELLOW);
		nowColor = Color.BLUE;
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));

		for (Line line: lines) {
			g2d.setColor(line.getColor());
			for (int i= 1; i< line.getSize(); i++) {
				g2d.drawLine(line.getX(i-1), line.getY(i-1), 
						line.getX(i), line.getY(i));
			}			
		}

		
	}
	
	public void clear() {
		recycler.clear();
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size() > 0) {
			recycler.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
		if (recycler.size() > 0) {
			lines.add(recycler.removeLast());
			repaint();
		}
	}
	
	
	public Color getColor() {
		return nowColor;
	}
	
	public void setColor(Color color) {
		nowColor = color;
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycler.clear();
			Line line = new Line(nowColor);
			line.addPoint(e.getX(), e.getY());
			lines.add(line);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			lines.getLast().addPoint(e.getX(), e.getY());
			repaint();
		}
		
	}
	
	
}






