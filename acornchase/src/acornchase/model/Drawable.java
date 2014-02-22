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
		if (x >= (x_location + WIDTH) ) return true;
		if (y >= (y_location + HEIGHT)) return true;
		else return false;
	}
	
}



