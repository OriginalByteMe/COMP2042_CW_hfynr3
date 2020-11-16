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
	

	public boolean getLeft() {
		return speed < 0;
	}
}
