package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;

public class Squirrel extends Movable {

	private int base_speed;

	public Squirrel(int position, int base_speed, Color col) {
		this.CONST_SPEED = 10;
		this.x_speed = base_speed;
		this.y_speed = 0;
		this.x_position = position;
		this.colour = col;

	}
	
	//jump 

	public void move() {
		if (x_position == 0) {
			x_speed = 0;
		}
		x_position -= x_speed;
	}
	
	//jump

	
	public void jump() {
		
	}
	
	//how fast the squirrel is moving
	public int getSpeed() {
		return x_speed;
	}
	
	//where the squirrel is on the screen
	public int getPosition() {
		return x_position;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Color savedCol = g.getColor();
		g.setColor(colour);
		g.fillRect(x_position - WIDTH / 2, y_position - HEIGHT / 2, WIDTH, HEIGHT);
		g.setColor(savedCol);
	}
}
