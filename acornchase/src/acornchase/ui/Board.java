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

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{
	private static final String OVER = "Game Over!";
	private static final String REPLAY = "R to replay";
	private Game game;
	Button[] buttons;
//<<<<<<< HEAD
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
	Timer timer;
	int counter2 = 0;
	int counter = 0;
	private int counterweight;


	public Board(Game g) {
		setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT)); 
		
		setSize(new Dimension(Game.WIDTH, Game.HEIGHT));  
		buttons = new Button[5];
		addMouseListener(new MAdapter()); //for the point n click
		setFocusable(true);
		setBackground(Color.BLACK); //I want this to be the image
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
		Graphics2D g2d = (Graphics2D)g;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("space.jpg"));
		Image image = ii.getImage();
		g2d.drawImage(image, -(1178 - 640) + (counter2), 0, this);
		if ((1178 - 640) == counter2) {
			counter2 = 0;
		}
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(counter), 20, 20);
		drawGame(g);
		drawUI(g);
		if (game.getState().compareTo("end")==0) {
			gameOver(g);
		}	      //  g.drawImage(bgImage, 0, 0, null);
	}

//<<<<<<< HEAD

	private void drawSprites(Graphics g) {
//		Squirrel sq = game.getSquirrel();
//
//		Graphics2D g2d = (Graphics2D)g;
//		ImageIcon ii = new ImageIcon(this.getClass().getResource("squirrel.png"));
//		Image image = ii.getImage();
//		g2d.drawImage(image, sq.getX() - (sq.getWidth() / 2), sq.getY() - (sq.getHeight() / 2),  this);
		
		

		
		
	}
//=======
//>>>>>>> branch 'master' of https://github.com/lsom/acornchase.git


	private void drawUI(Graphics g) {
		int height = game.HEIGHT - 70;
		int width = game.WIDTH / 5;
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(slowBlock.getImage(), 0, height, this);
		g2d.drawImage(freezeBlock.getImage(), width, height, this);
		g2d.drawImage(blockBlock.getImage(), width * 2, height, this);
		g2d.drawImage(turboBlock.getImage(), width * 3, height, this);
		g2d.drawImage(scareBlock.getImage(), width * 4, height, this);
		slowBounds = new Rectangle(0, height, 100, 50);
		freezeBounds = new Rectangle(width, height, 100, 50);
		blockBounds = new Rectangle(width * 2, height, 100, 50);
		turboBounds = new Rectangle(width * 3, height, 100, 50);
		scareBounds = new Rectangle(width * 4, height, 100, 50);
		
		// TODO Auto-generated method stub

	}


	private void gameOver(Graphics g) {
		Color saved = g.getColor();
		timer.stop();
		g.setColor(new Color( 255, 255, 255));
		g.setFont(new Font("Arial", 20, 20));
		FontMetrics fm = g.getFontMetrics();
		String end_game = OVER+ " You saved your acorn for: "+counter + " seconds";
		centreString(end_game, g, fm, Game.HEIGHT / 2);
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
				System.out.println("scareBounds");
				game.applyPower("scare");
			}
			if (turboBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("turboBounds");
				game.applyPower("turbo");

			}
			if (freezeBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("freezeBounds");
				game.applyPower("freeze");

			}
			if (slowBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("slowBounds");
				game.applyPower("slow");
			}
			if (blockBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("blockBounds");
				game.applyPower("block");
			}

		}

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (counterweight == 10) {
			counter +=1;
			counterweight = 1;
			game.updateSlow();
		} else {
			counterweight++;
		}
		counter2 += 1;
		game.update();
		repaint();
		
	}

}
