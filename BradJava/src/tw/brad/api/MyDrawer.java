package tw.brad.api;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	
	public void saveLines(File saveFile) throws Exception{
		try(ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream(saveFile))){
			oout.writeObject(lines);
		}
	}
	
	public void readLines(File loadFile) throws Exception{
		try (ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream(loadFile))){
			Object obj = oin.readObject();
			if (obj instanceof ArrayList) {
				lines = (ArrayList<Line>)obj;
				repaint();
			}else {
				throw new Exception("File Format ERROR");
			}
		}
	}
	
	public void saveJPEG(File saveFile) throws Exception{
		BufferedImage img = 
			new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		paint(g2d);
		g2d.dispose();
		
		ImageIO.write(img, "jpg", saveFile);
		
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






