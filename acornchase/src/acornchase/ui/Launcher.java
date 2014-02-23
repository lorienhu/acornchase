package acornchase.ui;
import javax.swing.JFrame;

import acornchase.model.Game;

@SuppressWarnings("serial")
public class Launcher extends JFrame{
	public Launcher() {
		add(new Board(new Game()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Game.WIDTH, Game.HEIGHT);
		setLocationRelativeTo(null);
		setTitle("AcornChase");
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Launcher();
	}	

}
