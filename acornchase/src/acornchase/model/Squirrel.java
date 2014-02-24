package acornchase.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Squirrel extends Movable {

	private int base_speed;
	public JumpPower jumpPower;
	public JPanel jp;
	public String which;
	private int basePos;

	public Squirrel(int position, int base_speed, Color col, JPanel jp, String which) {
		this.CONST_SPEED = 10;
		this.base_speed = base_speed;
		this.x_speed = base_speed;
		this.y_speed = 0;
		this.x_position = position;
		this.y_position = 275;
		this.colour = col;
		this.HEIGHT = 50;
		this.WIDTH = 80;
		this.jp = jp;
		this.which = which;
		basePos = position;
		
		jumpPower = new JumpPower(this);
	}
	
	public void setYSpeed(int i) {
		y_speed = i;
	}

	public void goBack() {
		x_speed = -10;
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
		if (jumpPower.isReady()) {
			y_speed = 10;
			jumpPower.activate();
			System.out.println("yo");
		}
	}

	//how fast the squirrel is moving
	public int getSpeed() {
		return x_speed;
	}

	//where the squirrel is on the screen
	public int getPosition() {
		return x_position;
	}

	public void draw(Graphics g, int counter) {
		Graphics2D g2d = (Graphics2D)g;
		ImageIcon ii;
		if (which.equals("player")) {
			if(counter%2 == 0)
				ii = new ImageIcon(this.getClass().getResource("squirrelplayer.png"));
			else
				ii = new ImageIcon(this.getClass().getResource("squirrelplayer2.png"));
		}
		else {
			if(counter%2 == 0)
				ii = new ImageIcon(this.getClass().getResource("squirrel.png"));
			else
				ii = new ImageIcon(this.getClass().getResource("squirrel2.png"));
		}
		Image image = ii.getImage();
		g2d.drawImage(image, x_position, y_position, jp);
	}

	public void reset() {
		x_position = basePos;
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
