package p4_group_8_repo;

import javafx.scene.image.Image;

public class obstacle extends MovingActor {
	private double speed;

	public obstacle(String imageLink, double size, double xPos, double yPos, double speed) {
		super(imageLink, size, xPos, yPos);
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	@Override
	public void act() {
		move(speed , 0);

		handleOutOfBounds();
	}



	public void handleOutOfBounds(){

		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -300 && speed<0)
			setX(600);
	}

	public String getActorClassName(){
		return "Obstacle";
	}
}
