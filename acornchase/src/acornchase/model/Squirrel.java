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
		this.base_speed = base_speed;
		this.x_speed = base_speed;
		this.y_speed = 0;
		this.x_position = position;
		this.y_position = 100;
		this.colour = col;
		this.HEIGHT = 50;
		this.WIDTH = 80;
	}

	public void goBack() {
		x_speed = -5;
	}
	
	public void slow() {
		if (x_speed>=2) {
		x_speed = x_speed-2;
		}
	}
	
	public void speedUp() {
		if (x_speed<base_speed*2) {
			x_speed = x_speed+5;
		}
		else if (x_speed<base_speed*4) {
			x_speed++;
		}
	}

	public void move() {
	x_position -= x_speed;
	y_position -= y_speed;
		if (x_position-WIDTH/2 <= 0) {
			x_speed = 0;
		}
	}
	
	//jump
	public void jump() {
		y_speed = 20;
		y_position = 200;
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
