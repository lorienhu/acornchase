package acornchase.model;

public abstract class Drawable {

	protected int x_location;	
	protected int y_location;
	protected int HEIGHT;
	protected int WIDTH;
	
	public Drawable () {
	}
	
	public int getX() {
		return x_location;
	}
	
	public void setLocation(int x) {
		x_location = x;
	}
	
	public boolean hasCollidedWith (int x, int y) {
		if ((x >= (x_location + WIDTH/2)) || (x <= (x_location - WIDTH/2)) ) return false;
		if ((y >= (y_location + HEIGHT/2)) || (y <= (y_location - HEIGHT/2))) return false;
		else return true;
	}
	
}



