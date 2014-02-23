package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class JumpBlock {
	Image image;
	public JumpBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Jump.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}
}
