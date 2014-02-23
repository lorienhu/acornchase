package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Drawable {

	protected int x_position;	
	protected int y_position;
	protected int HEIGHT;
	protected int WIDTH;
	protected Color colour;
	
	public Drawable () {
	}
	
	public abstract void draw(Graphics g);
	
	//x-coord of Drawable 
	public int getX() {
		return x_position;
	}
	//y-coord of Drawable
	public int getY() {
		return y_position;
	}
	//height of the Drawable
	public int getHeight() {
		return HEIGHT;
	} 
	//width of the Drawable
	public int getWidth() {
		return WIDTH;
	}
	//set new x-coord
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
		int xA = a.getX() - a.getWidth()/2; int yA = a.getY() + a.getHeight()/2; 
		int wA = a.getWidth(); int hA = a.getHeight();
		int xB = b.getX() - b.getWidth()/2; int yB = b.getY() + b.getHeight()/2; 
		int wB = b.getWidth(); int hB = b.getHeight();
		
		Rectangle rA = new Rectangle(xA, yA, wA, hA);
	    Rectangle rB = new Rectangle(xB, yB, wB, hB);
	    
	    if (rA.intersects(rB)) {
	    	return true;
	    }
	    else return false;
	}
	
}



