package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class replayBlock {

	Image image;
	public replayBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("replay.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}

}


