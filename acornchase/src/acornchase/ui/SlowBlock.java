package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class SlowBlock {
	Image image;
	public SlowBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Slow.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}

}
