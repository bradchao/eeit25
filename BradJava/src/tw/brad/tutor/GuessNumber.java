package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private String answer;
	private int counter;
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		//input = new JFormattedTextField();
		input = new JTextField();
		guess = new JButton("猜");
		log = new JTextArea();
		
		setLayout(new BorderLayout(4, 4));
		add(log, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		guess.addActionListener(this);
		initGame();
		
	}
	public static void main(String[] args) {
		new GuessNumber();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("OK");
		//System.out.println(createAnswer(4));
		
		counter++;
		
		String g = input.getText();
		String result = checkAB(answer, g);
		log.append(String.format("%d. %s => %s\n", counter, g, result));
		input.setText("");
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "WINNER");
			initGame();
		}else if (counter == 3) {
			JOptionPane.showMessageDialog(null, "Answer = " + answer);
			initGame();
		}
		
	}
	
	private void initGame() {
		answer = createAnswer(3);
		System.out.println(answer);
		counter = 0;
		log.setText("");
	}
	
	private static String createAnswer(int d) {
		int[] poker = new int[10];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i=0; i<poker.length; i++) {
			int rIndex = (int)(Math.random()*10);
			// poker[i] <-> poker[rIndex]
			int temp = poker[i];
			poker[i] = poker[rIndex];
			poker[rIndex] = temp; 
		}
		//-----------------------
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<d; i++) sb.append(poker[i]);
		return sb.toString();
	}
	
	private static String checkAB(String answer, String g) {
		int A, B; A = B = 0;
		for (int i=0; i<answer.length(); i++) {
			if (answer.charAt(i) == g.charAt(i)) {
				A++;
			}else if (answer.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		return String.format("%dA%dB", A, B);
	}
	

}
