package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.brad.api.MyClock;
import tw.brad.api.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo, color, saveLines, loadLines, saveJPEG;
	private MyClock myClock;

	public MySign() {
		
		setLayout(new BorderLayout());
		
		myDrawer = new MyDrawer();
		add(myDrawer, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear"); top.add(clear);
		undo = new JButton("Undo"); top.add(undo);
		redo = new JButton("Redo"); top.add(redo);
		color = new JButton("Color"); top.add(color);
		saveLines = new JButton("Save"); top.add(saveLines);
		loadLines = new JButton("Load"); top.add(loadLines);
		saveJPEG = new JButton("JPEG"); top.add(saveJPEG);
		myClock = new MyClock(); top.add(myClock);
		
		add(top, BorderLayout.NORTH);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		saveLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveLines();
			}
		});
		loadLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadLines();
			}
		});
		saveJPEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveJPEG();
			}
		});
	}

	private File file = null;
	
	private void saveLines() {
		try {
			if (file != null) {
				myDrawer.saveLines(file);
			}else {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
					file = jfc.getSelectedFile();
					myDrawer.saveLines(file);
				}
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Save Failure");
		}
	}
	private void loadLines() {
		try {
			JFileChooser jfc = new JFileChooser();
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				file = jfc.getSelectedFile();
				myDrawer.readLines(file);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Load Failure");
		}
	}
	private void saveJPEG() {
		try {
			JFileChooser jfc = new JFileChooser();
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File jpeg = jfc.getSelectedFile();
				myDrawer.saveJPEG(jpeg);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Save Failure");
		}
	}
	
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "Change Color", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.setColor(newColor);
		}
	}
	
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
