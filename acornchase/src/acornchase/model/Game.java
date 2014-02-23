package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

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
	
	private Power slowPower;
	
	public Game() {
		
		state = "start";
		time = 0;
		player = new Squirrel(PLAYER_START_POS, 0, Color.BLUE);
		enemy = new Squirrel(ENEMY_START_POS, 1, Color.RED);
	}
	
	// Update the game on a tick.
	public void update() {
		// Tick each power.
		// Move each squirrel.
		// Check for collisions.
		// Check for gameover.
		player.move();
		enemy.move();
		
		System.out.println(player.isBoink(enemy));
		enemy.move();		
		checkGameOver();
		
	}

	public void updateSlow() {
		// Tick each power.
		// Move each squirrel.
		// Check for collisions.
		// Check for gameover.
		enemy.speedUp();		
	}
	
	public void applyPower(String power) {
		if (power.equals("jump")) {
			player.jump();
		}
		else if (power.equals("turbo")) {
			turbo();
		}
		else if (power.equals("slow")) {
			block();
		}
		else if (power.equals("block")) {
			block();
		}
	}

	// Add speed to squirrel for turbopower length seconds.
	public void turbo() {
		enemy.slow();
	}
	
	// Block the squirrel from dying.
	public void block() {
		
	}
	
	// Lower the speed of the opposing squirrel.
	public void slow() {
		
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
