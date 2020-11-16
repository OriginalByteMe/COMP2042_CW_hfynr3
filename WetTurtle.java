package p4_group_8_repo;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WetTurtle extends Turtle{
	boolean sunk = false;

	public WetTurtle(String imageLink, double size, double xPos, double yPos, double speed) {
		super(imageLink, size, xPos, yPos, speed);

		animationCompile();
	}

	public void animationCompile(){
		List<Image> turtleFrames = new ArrayList<>();

		Image firstFrame = new Image("file:src/p4_group_8_repo/TurtleAnimation2Wet.png", size, size, true, true);
		Image secondFrame = new Image("file:src/p4_group_8_repo/TurtleAnimation3Wet.png", size, size, true, true);
		Image thirdFrame = new Image("file:src/p4_group_8_repo/TurtleAnimation4Wet.png", size, size, true, true);

		turtleFrames.addAll(Arrays.asList(firstFrame, secondFrame, thirdFrame));

		turtleAnimator(turtleFrames);
	}

	/*
	Wet-Turtle animation:
		Default -> Submerge -> Submerge further -> Submerged : Repeat
	 */
	public void turtleAnimator(List<Image> images){
		final int milliseconds = 1000;

		// For default Animation
		List<Image> defaultAnim = new ArrayList<>();
		defaultAnim.add(ActorImage);
		Transition defaultState = animate(defaultAnim, milliseconds);
		defaultState.setOnFinished(event -> {sunk = true;});

		// For sinking animation
		Transition sinkingState = animate(images,milliseconds);
		sinkingState.setOnFinished(event -> {sunk = false;});



		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(sinkingState, PauseAfterAnimation);

		animation.setCycleCount(Transition.INDEFINITE); // To ensure infinite loop

		animation.play();

	}

	@Override
	public String getActorClassName() {
		return "WetTurtle";
	}

	// Replace with animation machine
//	@Override
//	public void act(long now) {
//
//				if (now/900000000  % 4 ==0) {
//					setImage(turtle2);
//					sunk = false;
//				}
//				else if (now/900000000 % 4 == 1) {
//					setImage(turtle1);
//					sunk = false;
//				}
//				else if (now/900000000 %4 == 2) {
//					setImage(turtle3);
//					sunk = false;
//				} else if (now/900000000 %4 == 3) {
//					setImage(turtle4);
//					sunk = true;
//				}
//
//		move(speed , 0);
//		if (getX() > 600 && speed>0)
//			setX(-200);
//		if (getX() < -75 && speed<0)
//			setX(600);
//	}

	public boolean isSunk() {
		return sunk;
	}
}
