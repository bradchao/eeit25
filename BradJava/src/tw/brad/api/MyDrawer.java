package tw.brad.api;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	public MyDrawer() {
		setBackground(Color.YELLOW);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("OK");
	}
	
	
}
