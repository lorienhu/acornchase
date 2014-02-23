package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Squirrel extends Movable {

	private int base_speed;

	public Squirrel(int position, int base_speed, Color col) {
		this.CONST_SPEED = 10;
		this.x_speed = base_speed;
		this.y_speed = 0;
		this.x_position = position;
		this.y_position = 100;
		this.colour = col;
		this.HEIGHT = 50;
		this.WIDTH = 80;

	}
	
	//jump 

	public void move() {
	x_position -= x_speed;
		if (x_position-WIDTH/2 <= 0) {
			x_speed = 0;
		}
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
		g.fillRect (x_position - WIDTH / 2, y_position - HEIGHT / 2, WIDTH, HEIGHT);
		g.setColor(colour);
	}

}
