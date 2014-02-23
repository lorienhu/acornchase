package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JPanel;

import acornchase.ui.Board;
import acornchase.ui.Launcher;

//Represents an AcornGame.
public class Game {
	
	public static final int WIDTH = 640;
	public static final int HEIGHT =  480;
	public static final Random RND = new Random();

	
	private Squirrel player;
	private Squirrel enemy;
	
	public static final int PLAYER_START_POS = (int) (0.2*WIDTH);
	public static final int ENEMY_START_POS = (int) (0.8*WIDTH);

	
	private int time;
	public String state;
	public boolean isOver;
	
	public Power slowPower;
	public Power jumpPower;
	public Power turboPower;
	public Power blockPower;
	public Power scarePower;

	public JPanel jp;
	
	public Game() {
				
		state = "start";
		time = 0;
		player = new Squirrel(PLAYER_START_POS, 0, Color.BLUE, jp, "player");
		enemy = new Squirrel(ENEMY_START_POS, 2, Color.RED, jp, "enemy");
		
		slowPower = new Power(0, 3*10);
		jumpPower = player.jumpPower;
		turboPower = new Power(0, 3*10);
		blockPower = new Power(0, 3*10);
		scarePower = new Power(0, 3*10);

	}

	public void addBoard(Board b) {
		this.jp = b;
	}
	
	
	// Update the game on a tick.
	public void update() {
		// Tick each power.
		// Move each squirrel.
		// Check for collisions.
		// Check for gameover.
		player.move();
		enemy.move();		
		checkGameOver();
		
		turboPower.tick();
		slowPower.tick();
		jumpPower.tick();
		blockPower.tick();
		scarePower.tick();
		
	}

	public void updateSlow() {
		// Tick each power.
		// Move each squirrel.
		// Check for collisions.
		// Check for gameover.
		enemy.speedUp();		
	}
	
	public void applyPower(String power) {
		if (power.equals("jump") && jumpPower.isReady()) {
			player.jump();
		}
		else if (power.equals("turbo") && turboPower.isReady()) {
			turbo();
		}
		else if (power.equals("slow") && slowPower.isReady()) {
			slow();
		}
		else if (power.equals("block") && blockPower.isReady()) {
			block();
		}
		else if (power.equals("scare") && scarePower.isReady()) {
			scare();}
	}

	private void scare() {
		enemy.reset();
		scarePower.activate();
		
		
	}

	// Add speed to squirrel for turbopower length seconds.
	public void turbo() {
		enemy.goBack();
		turboPower.activate();
	}
	
	// Block the squirrel from dying.
	public void block() {
		blockPower.activate();
	}
	
	// Lower the speed of the opposing squirrel.
	public void slow() {
		enemy.slow();
		slowPower.activate();

		
	}
	
	public void draw(Graphics g) {
		player.draw(g);
		enemy.draw(g);
	}
	
	// Retrieves state of game.
	public String getState() {
		return state;
	}

	public void checkExpiry(Graphics g) {
	}
	
	private void checkGameOver() {
		if (player.isBoink(enemy)) {
			state = "end";
		}
	}
	
	public Squirrel getSquirrel() {
		return player;
	}
	 
}
