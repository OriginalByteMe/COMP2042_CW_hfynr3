package p4_group_8_repo;

import javafx.scene.image.Image;

public class Obstacle extends MovingActor {
	private int speed;

	public Obstacle(String imageLink, int size, int xPos, int yPos, int speed) {
		super(imageLink, size, xPos, yPos);
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	/* OutOfBounds */
	@Override
	public void act() {
		move(speed , 0);

		handleOutOfBounds();
	}



	public void handleOutOfBounds(){
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	public String getActorClassName(){
		return "Obstacle";
	}
}
