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
	private static final String REPLAY = "";
	private Game game;
	Button[] buttons;
	ScorePanel time;

	TurboBlock turboBlock;
	JumpBlock jumpBlock;
	SlowBlock slowBlock;
	BlockBlock blockBlock;
	ScareBlock scareBlock;
	Rectangle scareBounds;
	Rectangle turboBounds;
	Rectangle jumpBounds;
	Rectangle slowBounds;
	Rectangle blockBounds;
	replayBlock reBlock;
	Rectangle replayBounds;
	Timer timer;
	int counter2 = 0;
	int counter = 0;
	private int counterweight;
	Sound BlockSound;
	Sound SlowSound;
	Sound JumpSound; 
	Sound TurboSound;
	Sound ScareSound;

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
		jumpBlock = new JumpBlock();
		turboBlock = new TurboBlock();
		reBlock = new replayBlock();
		timer = new Timer(100, this);
		timer.start();
		BlockSound = new Sound("defense.wav");
		SlowSound = new Sound("slow.wav");
		JumpSound = new Sound("jump.wav");
		TurboSound = new Sound("turbo.wav");
		ScareSound = new Sound("scare.wav");
	}


	//This to set the background image, draw stuff
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("bg.jpg"));
		Image image = ii.getImage();
		g2d.drawImage(image, -(1280 - 640) + (counter2), 0, this);
		if ((1280 - 640) < counter2) {
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

	private void drawUI(Graphics g) {
		int height = Game.HEIGHT - 70;
		int width = Game.WIDTH / 5;
		Graphics2D g2d = (Graphics2D)g;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("unready.png"));
		Image img = ii.getImage();
		if (game.blockPower.isReady()) {
			g2d.drawImage(blockBlock.getImage(), width * 2, height, this);
		} else {
			g2d.drawImage(img, width * 2, height, this);
		}
		if (game.jumpPower.isReady()) {
			g2d.drawImage(jumpBlock.getImage(), width, height, this);

		} else {
			g2d.drawImage(img, width, height, this);
		}
		if (game.scarePower.isReady()) {
			g2d.drawImage(scareBlock.getImage(), width * 4, height, this);

		} else {
			g2d.drawImage(img, width, height, this);
		}
		if (game.slowPower.isReady()) {
			g2d.drawImage(slowBlock.getImage(), 0, height, this);

		} else {
			g2d.drawImage(img, 0, height, this);
		}
		if (game.turboPower.isReady()) {
			g2d.drawImage(turboBlock.getImage(), width * 3, height, this);

		} else  {
			g2d.drawImage(img, width * 3, height, this);
		}
		
		slowBounds = new Rectangle(0, height, 100, 50);
		jumpBounds = new Rectangle(width, height, 100, 50);
		blockBounds = new Rectangle(width * 2, height, 100, 50);
		turboBounds = new Rectangle(width * 3, height, 100, 50);
		scareBounds = new Rectangle(width * 4, height, 100, 50);
	}


	private void gameOver(Graphics g) {
		Color saved = g.getColor();
		
		g.setColor(new Color( 0, 0, 0));
		g.setFont(new Font("Serif", Font.BOLD , 30));
		FontMetrics fm = g.getFontMetrics();
		String end_game = OVER+ " You saved your acorn for: "+counter + " seconds";
		centreString(end_game, g, fm, Game.HEIGHT / 2);
		centreString(REPLAY, g, fm, Game.HEIGHT / 2 + 50);
		g.setColor(saved);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(reBlock.getImage(), 300, 250, this);
		replayBounds = new Rectangle(300,250,63, 62);
		timer.stop();
		
		
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
				if (game.scarePower.isReady()) {
					ScareSound.play();
				}
				game.applyPower("scare");
			}
			if (turboBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("turboBounds");
				if (game.scarePower.isReady()) { 
					TurboSound.play();
				}
				game.applyPower("turbo");

			}
			if (jumpBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("jumpBounds");
				if (game.scarePower.isReady()) {
					JumpSound.play();
				}
				game.applyPower("jump");
			}
			if (slowBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("slowBounds");
				if (game.scarePower.isReady()) {
					SlowSound.play();
				}
				game.applyPower("slow");
			}
			if (blockBounds.contains(new Point(e.getX(), e.getY()))) {
				System.out.println("blockBounds");
				if (game.scarePower.isReady()) {
					BlockSound.play();
				}
				game.applyPower("block");
			}
			if(replayBounds.contains(new Point(e.getX(), e.getY())))
			{
				System.out.println("reBounds");
				reset();
			}
		}
	}

	public void reset()
	{
		game = new Game();
		timer = new Timer(100, this);
		timer.start();
		counter = 0;
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
		counter2 += 5;
		game.update();

		repaint();		

	}

}
