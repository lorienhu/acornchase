package acornchase.ui;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import acornchase.model.Game;

@SuppressWarnings("serial")
public class Launcher extends JFrame{
	private Game game;
	public Launcher() {
		game = new Game();
		Board board = new Board(game);
		game.addBoard(board);
		add(board);
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
