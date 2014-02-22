package acornchase.ui;


import javax.swing.JFrame;

import acornchase.model.Game;

public class Launcher extends JFrame{
	public Launcher() {
		add(new Board(new Game()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setTitle("Game");
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Launcher();
	}
	

}
