package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Obstacle {

	private double speed;


	public Log(String imageLink, int size, int xPos, int yPos, int speed, double speed1) {
		super(imageLink, size, xPos, yPos, speed);
		this.speed = speed1;
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
