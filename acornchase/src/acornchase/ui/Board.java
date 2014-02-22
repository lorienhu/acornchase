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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import acornchase.model.Game;
import acornchase.model.Squirrel;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{
	private static final String OVER = "Game Over!";
	private static final String REPLAY = "R to replay";
	private Game game;
	Button[] buttons;
//<<<<<<< HEAD
	ScorePanel time;
//=======
//>>>>>>> branch 'master' of https://github.com/lsom/acornchase.git
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
	Timer timer;
	int counter = 0;


	public Board(Game g) {
		buttons = new Button[5];
		addMouseListener(new MAdapter()); //for the point n click
		setFocusable(true);
		setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));  
		setBackground(Color.GRAY); //I want this to be the image
		this.game = g;
		scareBlock = new ScareBlock();
		blockBlock = new BlockBlock();
		slowBlock = new SlowBlock();
		freezeBlock = new FreezeBlock();
		turboBlock = new TurboBlock();
		timer = new Timer(100, this);
		timer.start();
		


	}


	//This to set the background image, draw stuff
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(Integer.toString(counter), 20, 20);
		drawGame(g);
		drawUI(g);
		if(game.getState().compareTo("start")==0)
		{
			time = new ScorePanel(this.game);
		}
			
		if (game.getState().compareTo("end")==0) {
			gameOver(g);
		}	      //  g.drawImage(bgImage, 0, 0, null);
	}


	private void drawUI(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(slowBlock.getImage(), 0, 330, this);
		g2d.drawImage(freezeBlock.getImage(), 100, 330, this);
		g2d.drawImage(blockBlock.getImage(), 200, 330, this);
		g2d.drawImage(turboBlock.getImage(), 300, 330, this);
		g2d.drawImage(scareBlock.getImage(), 400, 330, this);
		slowBounds = new Rectangle(0, 330, 100, 50);
		freezeBounds = new Rectangle(100, 330, 100, 50);
		blockBounds = new Rectangle(200, 330, 100, 50);
		turboBounds = new Rectangle(300, 330, 100, 50);
		scareBounds = new Rectangle(400, 330, 100, 50);
		
		// TODO Auto-generated method stub

	}


	private void gameOver(Graphics g) {
		Color saved = g.getColor();
		g.setColor(new Color( 0, 0, 0));
		g.setFont(new Font("Arial", 20, 20));
		FontMetrics fm = g.getFontMetrics();
		centreString(OVER, g, fm, Game.HEIGHT / 2);
		centreString(REPLAY, g, fm, Game.HEIGHT / 2 + 50);
		g.setColor(saved);
	}

	private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
		int width = fm.stringWidth(str);
		g.drawString(str, (Game.WIDTH - width) / 2, yPos);
	}

	private void drawGame(Graphics g) {
		

	}


	private class MAdapter extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (scareBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("scareBounds");
			}
			if (turboBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("turboBounds");
			}
			if (freezeBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("freezeBounds");
			}
			if (slowBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("slowBounds");
			}
			if (blockBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("blockBounds");
			}

		}

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		counter += (timer.getDelay() / 1000);
		System.out.println(counter);
		game.update();
		repaint();
		
	}

}
