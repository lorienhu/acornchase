package acornchase.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import acornchase.model.Game;
import acornchase.model.Squirrel;

@SuppressWarnings("serial")
public class Board extends JPanel{
	private static final String OVER = "Game Over!";
	private static final String REPLAY = "R to replay";
	private Game game;
	Button[] buttons;
	ScorePanel score;
	ScorePanel time;

	public Board(Game g) {
		buttons = new Button[5];
		addMouseListener(new MAdapter()); //for the point n click
		setFocusable(true);
		time =  new ScorePanel();
		setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));  
		setBackground(Color.GRAY); //I want this to be the image
		this.game = g;
		

	}


	//This to set the background image, draw stuff
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGame(g);
		if (game.getState().compareTo("end")==0) {
			gameOver(g);
		}	      //  g.drawImage(bgImage, 0, 0, null);
	}


	private void gameOver(Graphics g) {
		Color saved = g.getColor();
		g.setColor(new Color( 0, 0, 0));
		g.setFont(new Font("Arial", 20, 20));
		FontMetrics fm = g.getFontMetrics();
		String finalStr = OVER + time.getFinalTime();
		centreString(OVER, g, fm, Game.HEIGHT / 2);
		centreString(REPLAY, g, fm, Game.HEIGHT / 2 + 50);
		g.setColor(saved);
	}

	private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
		int width = fm.stringWidth(str);
		g.drawString(str, (Game.WIDTH - width) / 2, yPos);
	}

	private void drawGame(Graphics g) {
		game.draw(g);  
		
	}


	private class MAdapter extends MouseAdapter {

	}

}
