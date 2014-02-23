package acornchase.model;

import java.awt.Graphics;

public class Power extends Drawable {

	private int timer;
	private int length;
	private int cooldown;

	public Power(int l, int cd) {
		timer = 0;
		length = l;
		cooldown = cd;

	}
	
	public void afflict() {
		
	}
	
	public void tick() {
	}
	
	public int getCooldown() {
		return cooldown;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}	
	
	
}
