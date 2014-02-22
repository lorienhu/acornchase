package acornchase.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;




public class ScorePanel extends JPanel{
	
	// Text file and size of this textFIle
	private Timer myTimer1;
	public static final int ONE_SEC = 1000;   //time step in milliseconds
	public static final int TENTH_SEC = 100;
	private Font myClockFont;
	private int clockTick;  	//number of clock ticks; tick can be 1.0 s or 0.1 s
	private double clockTime;  	//time in seconds
	private JLabel timeLbl;
	private JPanel topPanel, bottomPanel;
	private String clockTimeString;
	
	
	
 
	
	
	// Constructs a score panel
	// effects: sets the background colour and draws the initial labels;
	//          updates this with the game whose score is to be displayed 
	public ScorePanel() { 
		// set the back ground and text to be shown	
		clockTick = 0;  		//initial clock setting in clock ticks
		clockTime = ((double)clockTick)/10.0;

		clockTimeString = new Double(clockTime).toString();
		myClockFont = new Font("Serif", Font.PLAIN, 50);

		timeLbl = new JLabel();
		timeLbl.setFont(myClockFont);
		timeLbl.setText(clockTimeString);
		
		myTimer1 = new Timer(TENTH_SEC, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clockTick++;
				clockTime = ((double)clockTick)/10.0;
				clockTimeString = new Double(clockTime).toString();
				timeLbl.setText(clockTimeString);
				//System.out.println(clockTime);
			    }
			});
		
	}
	
	public void launchStopWatch()
	{
		topPanel = new JPanel();
		topPanel.setBackground(Color.orange);
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.yellow);
		topPanel.add(timeLbl);
		

		this.setLayout(new BorderLayout());

		add(topPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(300,200);
		setBackground(Color.orange);

	}//end of launchClock

	public void startTimer() {
		myTimer1.start();
	}
	
	public void stopTimer() {
		myTimer1.stop();
	}
	
	public void getFinalTIme() {
		
	}
	

}
