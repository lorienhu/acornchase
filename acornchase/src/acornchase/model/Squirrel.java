package acornchase.model;

public class Squirrel extends Movable {


	private int base_speed;

	public Squirrel(int position, int base_speed) {
		this.CONST_SPEED = 10;
		this.x_speed = base_speed;
		this.y_speed = 0;
		this.x_position = position;

	}
	
	//jump 

	public void move() {
		if (x_position == 0) {
			x_speed = 0;
		}
		x_position -= x_speed;
	}
	
	//jump

	
	public void jump() {
		
	}
	
	//how fast the squirrel is moving
	public int getSpeed() {
		return x_speed;
	}
	
	//where the squirrel is on the screen
	public int getPosition() {
		return x_position;
	}
}
