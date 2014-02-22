package main;

import javax.swing.JFrame;


public class Run extends JFrame{
	
	public Run() {
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setTitle("Acorn Wars");
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Run();
		
	}

}
