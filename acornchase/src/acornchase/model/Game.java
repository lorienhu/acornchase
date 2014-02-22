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
	
	private SlowPower slowPower;
	private BlockPower blockPower;
	private FreezePower freezePower;
	private TurboPower turboPower;
	private ReversePower reversePower;

	
	private int time;
	public String state;
	public boolean isOver;
	
	public Game() {
		state = "start";
		time = 0;
		player = new Squirrel();
		enemy = new Squirrel();
	}
	
	public void applyPower(String power) {
	}
	
	public void draw(Graphics g) {

	}
	
	// Update the game.
	public void update() {}
	
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
