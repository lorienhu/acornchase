package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ScareBlock {

	Image image;
	public ScareBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Scare.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}

}
