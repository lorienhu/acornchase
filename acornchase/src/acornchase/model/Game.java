package acornchase.model;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

//Represents an AcornGame.
public class Game {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Random RND = new Random();
	
	private Squirrel player;
	private Squirrel enemy;
	
	public static final int PLAYER_START_POS = (int) (0.3*WIDTH);
	public static final int ENEMY_START_POS = (int) (0.8*WIDTH);

	
	private int time;
	public String state;
	public boolean isOver;
	
	private Power slowPower;
	
	public Game() {
		state = "start";
		time = 0;
		player = new Squirrel(PLAYER_START_POS);
		enemy = new Squirrel(ENEMY_START_POS);
	}
	
	// Update the game on a tick.
	public void update() {}
	
	
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
	}
	
	// Block the squirrel from dying.
	public void block() {
		
	}
	
	// Lower the speed of the opposing squirrel.
	public void slow() {
		
	}
	
	public void draw(Graphics g) {

	}
	
	// Retrieves state of game.
	public String getState() {
		return state;
	}
	
	private void checkCollisions() {
	}

	public void checkExpiry(Graphics g) {
	}
	
	private void checkGameOver()   {
		
	}
	 

}
