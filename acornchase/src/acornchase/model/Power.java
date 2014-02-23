package acornchase.model;

import java.awt.Graphics;
import java.util.Observable;

public class Power extends Drawable {
	private int timer;
	private int length;
	private int cooldown;
	private String status;

	public Power(int l, int cd) {
		timer = 0;
		length = l;
		cooldown = cd;
		status = "off";
	}
	
	public String getStatus() {
		return status;
	}
	
	public boolean isReady() {
		return (status.equals("off"));
	}
	
	public boolean isActive() {
		return (status=="on");
	}
	
	public void activate() {
		status = "on";
	}
	
	public void deactivate() {
		status = "cd";
	}
	
	public void tick() {
				
		if (!status.equals("off")) {
			timer++;
		
			if (timer == length) {
				deactivate();
			}
		
			if (timer == cooldown) {
				status = "off";
				timer = 0;
				System.out.println("ready to use");
			}
		}
	}
	
	public int getCooldown() {
		return (cooldown-timer);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}	
	
	
}
