package acornchase.model;

public class Squirrel extends Movable {

	public static int CONST_SPEED;

	public Squirrel(int position) {
		this.CONST_SPEED = 10;
		this.speed = CONST_SPEED;
		this.posX = position;
	}
	
	//jump
	
	public void jump() {
		
	}
	
	//how fast the squirrel is moving
	public int getSpeed() {
		return speed;
	}
	
	//where the squirrel is on the screen
	public int getPosition() {
		return posX;
	}
}
