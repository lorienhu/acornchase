package acornchase.ui;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private AudioClip clip;
	AudioInputStream au;
	Clip c;
	
	public Sound(String filename) {
		try {
			au = AudioSystem.getAudioInputStream(this.getClass().getResource(filename));
			c = AudioSystem.getClip();
			c.open(au);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		try {
			new Thread() {
				public void run() {
					c.start();
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
