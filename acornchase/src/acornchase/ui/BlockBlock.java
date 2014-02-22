package acornchase.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BlockBlock {
	Image image;
	public BlockBlock() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Block.png"));
		image = ii.getImage();
	}
	public Image getImage() {
		return image;
	}

}
