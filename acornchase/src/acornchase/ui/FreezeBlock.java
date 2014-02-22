package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FreezeBlock {
	Image image;
	public FreezeBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Freeze.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}
}
