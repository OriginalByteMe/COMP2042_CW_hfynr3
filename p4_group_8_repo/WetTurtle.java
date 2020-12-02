package p4_group_8_repo;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WetTurtle extends Turtle{
	private boolean sunk;

	public WetTurtle(String imageLink, double size, double xPos, double yPos, double speed) {
		super(imageLink, size, xPos, yPos, speed);


	}

	public void animationCompile(){
		final int milliseconds = 1500;
		List<Image> turtleFrames = new ArrayList<>();

		Image firstFrame = new Image("file:src/Resources/TurtleAnimation2Wet.png", size, size, true, true);
		Image secondFrame = new Image("file:src/Resources/TurtleAnimation3Wet.png", size, size, true, true);
		Image thirdFrame = new Image("file:src/Resources/TurtleAnimation4Wet.png", size, size, true, true);

		turtleFrames.addAll(Arrays.asList(firstFrame, secondFrame, thirdFrame));

		turtleAnimator(turtleFrames, milliseconds);
	}

	/*
	Wet-Turtle animation:
		Default -> Submerge -> Submerge further -> Submerged : Repeat
	 */
	public void turtleAnimator(List<Image> images, int milliseconds){


		// For default Animation
		List<Image> defaultAnim = new ArrayList<>();
		defaultAnim.add(ActorImage);
		Transition defaultState = animate(defaultAnim, milliseconds);
		defaultState.setOnFinished(event -> {sunk = true;});

		// For sinking animation
		Transition sinkingState = animate(images,milliseconds);
		sinkingState.setOnFinished(event -> {sunk = false;});



		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(defaultState, sinkingState, PauseAfterAnimation);

		animation.setCycleCount(SequentialTransition.INDEFINITE); // To ensure infinite loop

		animation.play();

	}

	@Override
	public String getActorClassName() {
		return "WetTurtle";
	}

	public boolean isSunk() {
		return sunk;
	}




}
