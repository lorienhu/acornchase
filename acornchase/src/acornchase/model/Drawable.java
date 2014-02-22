package acornchase.model;

public abstract class Drawable {

	public int x_location;	
	public int y_location;
	public int HEIGHT;
	public int WIDTH;
	
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



