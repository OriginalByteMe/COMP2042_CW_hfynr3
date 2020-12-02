package p4_group_8_repo;

public class Log extends obstacle {

	private double speed;


	public Log(String imageLink, double size, double xPos, double yPos, double speed) {
		super(imageLink, size, xPos, yPos, speed);
		this.speed = speed;
	}

	@Override
	public void act() {
		move(speed , 0);

		handleOutOfBounds();
	}
	
//	@Override
//	public void handleOutOfBounds(){
//		if (getX() > 700 && speed>0)
//			setX(-200);
//		if (getX() < -50 && speed<0)
//			setX(600);
//	}
	public boolean getLeft() {
		return speed < 0;
	}
}
