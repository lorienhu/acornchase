package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TurboBlock {
	Image image;
	public TurboBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Turbo.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}
	
}
