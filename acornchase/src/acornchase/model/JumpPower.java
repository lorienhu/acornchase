package acornchase.model;

public class JumpPower extends Power {
	
	private Squirrel squirrel;

	public JumpPower(Squirrel sq) {
		super(10, 10);
		squirrel = sq;
	}
	
	@Override
	public void tick() {
		
		if (!status.equals("off")) {
			timer++;
			
			if (timer == length/2) {
				System.out.println("here");
				squirrel.setYSpeed(-10);
				deactivate();
			}
		
			if (timer == length) {
				deactivate();
				squirrel.setYSpeed(0);
			}
		
			if (timer == cooldown) {
				status = "off";
				timer = 0;
				System.out.println("ready to use");
			}
		}
	}

}
