package tw.brad.api;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		MyListener myListener = new MyListener(this);
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		if (g instanceof DebugGraphics) {
//			System.out.println("1");
//		}else if (g instanceof Graphics2D) {
//			System.out.println("2");
//		}else {
//			System.out.println("3");
//		}

		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(Color.BLUE);
		g2d.drawLine(0, 0, 200, 300);
		
	}
}

class MyListener extends MouseAdapter {
	private MyDrawer myDrawer;
	
	public MyListener(MyDrawer myDrawer) {
		this.myDrawer = myDrawer;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		System.out.println("mousePressed");
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseDragged(e);
		System.out.println("mouseDragged");
	}
	
}





