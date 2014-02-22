package acornchase.model;

public class Power extends Drawable {

	private int timer;
	private int cooldown;
	private int length;
	private Squirrel squirrel;
	
	public Power(Squirrel sqr) {
		timer = 0;
		squirrel = sqr;
	}
	
	public void afflict() {
		
	}
	
	public void tick() {
	}
	
	public int getCooldown() {
		return cooldown;
	}	
	
	
}
