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

	/**
	 * <p>Compiles all images for turtle animation</p>
	 */
	public void animationCompile() {
		List<Image> turtleFrames = new ArrayList<>();

		Image firstFrame = new Image("file:src/main/resources/TurtleAnimation2.png", size, size, true, true);
		Image secondFrame = ActorImage; // Second frame is where tutrtle is in idle animation
		Image thirdFrame = new Image("file:src/main/resources/TurtleAnimation3.png", size, size, true, true);

		turtleFrames.addAll(Arrays.asList(firstFrame, secondFrame, thirdFrame));

		turtleAnimator(turtleFrames);
	}

	/**
	 * <h1>Turtle Animator</h1>
	 *
	 * @param images List of images to be used for animation
	 * @see Transition
	 */
	public void turtleAnimator(List<Image> images) {
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

}