package acornchase.model;

public class Squirrel extends Movable {

	public static int CONST_SPEED;
	
	protected int speed; 
	protected int posX;

	public Squirrel(int position) {
		this.CONST_SPEED = 10;
		this.speed = CONST_SPEED;
		this.posX = position;
		
		
		
	}
	
	//increase in the speed of the squirrel
	public int turbo() {
		return 0;
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
