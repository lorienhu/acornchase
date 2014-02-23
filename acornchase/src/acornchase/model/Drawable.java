package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Drawable {

	protected int x_position;	
	protected int y_position;
	protected int HEIGHT;
	protected int WIDTH;
	protected Color colour;
	
	public Drawable () {
	}
	
	public abstract void draw(Graphics g);
	
	public int getX() {
		return x_position;
	}
	
	public int getY() {
		return y_position;
	}

	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public void setLocation(int x) {
		x_position = x;
	}
	
	//returns true if a point is inside a Drawable
	public boolean hasCollidedWith (int x, int y) {
		if ((x > (x_position + WIDTH/2)) || (x < (x_position - WIDTH/2)) ) return false;
		if ((y > (y_position + HEIGHT/2)) || (y < (y_position - HEIGHT/2))) return false;
		else return true;
	}
	
	//returns true if two Drawables have collided
	public boolean isBoink(Drawable a, Drawable b) {
		int dA = a.getX();
		int dB = a.getX();
		
		return true;
	}
	
	
	
	
}



