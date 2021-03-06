package acornchase.model;

public abstract class Movable extends Drawable {

	private char direction = 'L';
	
	public static int CONST_SPEED;
	protected int y_speed;
	protected int x_speed; 
	
	public void setDirection(char c) {
		direction = c;
	}

	// Moves the squirrel/movables
	// modifies: this
	// effects:  squirrel/movables has been moved
	public void move() {
		handleBoundary();
	}
	
	// Constrains squirrel/movables so that it doesn't travel off sides of screen
	// modifies: this
	// effects: squirrel/movables is constrained to remain within horizontal boundaries of game
	protected void handleBoundary() {
		if (x_position < 0)
			x_position = 0;
		else if (x_position > Game.WIDTH)
			x_position = Game.WIDTH;
	}


}

