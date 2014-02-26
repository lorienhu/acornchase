package acornchase.model;

public class JumpPower extends Power {
	
	private Squirrel squirrel;
	private int currentSpeed;

	public JumpPower(Squirrel sq) {
		super(10, 10);
		squirrel = sq;
	}
	
	@Override
	public void tick() {
		currentSpeed = squirrel.getSpeed();
		if (!status.equals("off")) {
			timer++;
			
//			if (timer == length/2) {
//				System.out.println("here");
//				squirrel.setYSpeed(-10);
//				deactivate();
//			}
			if(timer < length/2) {
				squirrel.setYSpeed(currentSpeed - (timer-(length/2)));
			}
			if(timer != length && timer > length/2) {
				squirrel.setYSpeed(currentSpeed - (timer+length));
			}
			
		
			if (timer == length) {
				deactivate();
				squirrel.setYSpeed(0);
				squirrel.y_position = 275;
			}
		
			if (timer == cooldown) {
				status = "off";
				timer = 0;
				System.out.println("ready to use");
			}
		}
	}

}
