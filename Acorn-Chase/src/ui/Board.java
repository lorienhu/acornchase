package main;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import objects.Acorn;
import objects.God;
import objects.Squirrel;
import ui.Button;
import ui.Score;

public class Board extends JPanel{
	Squirrel squirrel;
	Button[] buttons;
	God god;
	Acorn acorn;
	Score score;
	
	public Board() {
		buttons = new Button[5];
		
		addKeyListener(new TAdapter());
		addMouseListener(new MAdapter());
		setFocusable(true);
		
		
	}
	
	
	private class TAdapter extends KeyAdapter {
		
	}
	
	private class MAdapter extends MouseAdapter {
		
	}

}
