package acornchase.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import acornchase.model.Game;
public class Launcher extends JFrame {

	private static final int INTERVAL = 20;
	private Game game;
	private Board b;
	private ScorePanel sp;
	private Timer t;

	// Constructs main window
	// effects: sets up window in which Space Invaders game will be played
	public Launcher() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		game = new Game();
		b = new Board(game);
		sp = new ScorePanel(game);
		add(gp);
		add(sp, BorderLayout.NORTH);
		addKeyListener(new KeyHandler());
		pack();
		centreOnScreen();
		setVisible(true);
		addTimer();
		t.start();
	}
	
	// Set up timer
	// modifies: none
	// effects:  initializes a timer that updates game each
	//           INTERVAL milliseconds
	private void addTimer() {
		t = new Timer(INTERVAL, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				game.update();
				gp.repaint();
				sp.update();
			}
		});
	}
	
	// Centres frame on desktop
	// modifies: this
	// effects:  location of frame is set so frame is centred on desktop
	private void centreOnScreen() {
		Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
	}
	
	

}
