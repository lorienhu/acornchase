package acornchase.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	TurboBlock turboBlock;
	FreezeBlock freezeBlock;
	SlowBlock slowBlock;
	BlockBlock blockBlock;
	ScareBlock scareBlock;
	Rectangle scareBounds;
	Rectangle turboBounds;
	Rectangle freezeBounds;
	Rectangle slowBounds;
	Rectangle blockBounds;


	public Board(Game g) {
		buttons = new Button[5];
		addMouseListener(new MAdapter()); //for the point n click
		setFocusable(true);
		time =  new ScorePanel();
		setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));  
		setBackground(Color.GRAY); //I want this to be the image
		this.game = g;
		scareBlock = new ScareBlock();
		blockBlock = new BlockBlock();
		slowBlock = new SlowBlock();
		freezeBlock = new FreezeBlock();
		turboBlock = new TurboBlock();


	}


	//This to set the background image, draw stuff
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGame(g);
		drawUI(g);
		if (game.getState().compareTo("end")==0) {
			gameOver(g);
		}	      //  g.drawImage(bgImage, 0, 0, null);
	}


	private void drawUI(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(turboBlock.getImage(), 0, 330, this);
		g2d.drawImage(freezeBlock.getImage(), 100, 330, this);
		g2d.drawImage(slowBlock.getImage(), 200, 330, this);
		g2d.drawImage(blockBlock.getImage(), 300, 330, this);
		g2d.drawImage(slowBlock.getImage(), 400, 330, this);
		scareBounds = new Rectangle(0, 330, 100, 50);
		turboBounds = new Rectangle(0, 330, 100, 50);
		freezeBounds = new Rectangle(0, 330, 100, 50);
		slowBounds = new Rectangle(0, 330, 100, 50);
		blockBounds = new Rectangle(0, 330, 100, 50);
		// TODO Auto-generated method stub

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
		public void mouseClicked(MouseEvent e) {
			if (scareBounds.contains(new Point(e.getX(), e.getY()))) {

			}
			if (turboBounds.contains(new Point(e.getX(), e.getY()))) {

			}
			if (freezeBounds.contains(new Point(e.getX(), e.getY()))) {

			}
			if (slowBounds.contains(new Point(e.getX(), e.getY()))) {

			}
			if (blockBounds.contains(new Point(e.getX(), e.getY()))) {

			}

		}

	}

}
