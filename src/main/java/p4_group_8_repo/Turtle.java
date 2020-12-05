package p4_group_8_repo;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Turtle extends obstacle {

	public Turtle(String imageLink, double size, double xPos, double yPos, double speed) {
		super(imageLink, size, xPos, yPos, speed);
		animationCompile();
	}

	public void animationCompile(){
		List<Image> turtleFrames = new ArrayList<>();

		Image firstFrame = new Image("file:src/main/resources/TurtleAnimation2.png", size, size, true, true);
		Image secondFrame = ActorImage; // Second frame is where tutrtle is in idle animation
		Image thirdFrame = new Image("file:src/main/resources/TurtleAnimation3.png", size, size, true, true);

		turtleFrames.addAll(Arrays.asList(firstFrame, secondFrame, thirdFrame));

		turtleAnimator(turtleFrames);
	}

	public void turtleAnimator(List<Image> images){
		final int milliseconds = 1000;

		Transition turtleAnimation = animate(images, milliseconds);

		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(turtleAnimation, PauseAfterAnimation);

		animation.setCycleCount(Transition.INDEFINITE); // To ensure infinite loop

		animation.play();

	}

	@Override
	public String getActorClassName() {
		return "Turtle";
	}

	// Also replace with a more general constructor
//	public Turtle(int xpos, int ypos, int s, int w, int h) {
//		turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", w, h, true, true);
//		turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2.png", w, h, true, true);
//		turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", w, h, true, true);
//		setX(xpos);
//		setY(ypos);
//		speed = s;
//		setImage(turtle2);
//	}


// Replace with animation machine
//	@Override
//	public void act(long now) {
//
//				if (now/900000000  % 3 ==0) {
//					setImage(turtle2);
//
//				}
//				else if (now/900000000 % 3 == 1) {
//					setImage(turtle1);
//
//				}
//				else if (now/900000000 %3 == 2) {
//					setImage(turtle3);
//
//				}
//
//		move(speed , 0);
//		if (getX() > 600 && speed>0)
//			setX(-200);
//		if (getX() < -75 && speed<0)
//			setX(600);
//	}

}
