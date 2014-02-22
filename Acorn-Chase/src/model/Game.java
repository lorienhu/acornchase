package acornchase;

// Represents an AcornGame.
public class Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Random RND = new Random();
	
	private Squirrel player;
	private Squirrel enemy;
	
	private List<Power> powers;
	
	private int time;
	
	public String state;
	
	public Game() {
		state = "start";
		time = 0;
		player = new Squirrel();
		enemy = new Squirrel();
	}
	
	// Update the game.
	public void update() {}

}
