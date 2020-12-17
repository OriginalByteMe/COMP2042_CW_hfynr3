package p4_group_8_repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class Animal extends Player {
	private int score = 0;
	private int numEndsReached = 0;
	private double end_pocket = 800;
	private boolean changeScore = false;


	public Animal(String imageLink, double size, double xPos, double yPos) {
		super(imageLink, size, xPos, yPos);
	}

	@Override
	public void act() {
		if(stop){
			return;
		}

		handlePlayerInteractions();
		HandleOutOfBoundsEvent();
	}



	/**
	 * <h1>Handling Player Interactions</h1>
	 * <p>Handles water death + Log riding interaction</p>
	 */
	public void handlePlayerInteractions(){
		List<Actor> actorIntersect = getIntersectingObjects(Actor.class);

		final boolean ReachedWater = getY() < 413; // Should make this dynamic as map water distance could change depending on level

		final boolean noInteractions = actorIntersect.isEmpty();

		if(ReachedWater && noInteractions){
			waterDeath();
			return;
		}

		for(Actor actor: actorIntersect){
			handlePlayerInteractions(actor);
		}


	}

	/**
	 * <h1>Handling Player Interactions 2</h1>
	 * <p>Handles death by other Actors, also handles end interactions (Getting Points from end pockets)</p>
	 * @param actor In this case any obstacle or static end
	 */
	public void handlePlayerInteractions(Actor actor){
		final String actorName = actor.getActorClassName();

		// If the current obstacle interaction class name is equal to either of these cases the boolean will become true
		final boolean carDeath = actorName.equalsIgnoreCase("Car");
		final boolean waterDeath = actorName.equalsIgnoreCase("WetTurtle") && ( (WetTurtle) actor ).isSunk() ;

		// If player interacted with an end goal boolean will become true
		final boolean endReached = actorName.equalsIgnoreCase("End");

		if(carDeath){ 	// If car interaction
			carDeath(); // Play animation
			return; 	// Onto next interaction
		}
		else if(waterDeath){
			waterDeath();
			return;
		}
		if(endReached){
			handleEnd((End) actor);
			return;
		}

		if(actor instanceof obstacle){ //If player is intersecting with (stands on) any actor of type obstacle (Turtle or Log)
			playerMount((obstacle) actor); // The player will move at the same speed as that obstacle in the same direction
		}
	}

	/**
	 * <h1>Handling End</h1>
	 * <p>Activates and Deactivates end depending on current state.</p>
	 * <p>Adds/Subtracts points for reaching either reaching new end or old one</p>
	 * @param end one of many End goals situated at the end of the stage
	 */
	public void handleEnd(End end){
		if(end.isActivated()){
			end.deactivate();
			numEndsReached--;
			subtractPoints(50);
		}
		else{
			end.activate();
			numEndsReached++;
			addPoints(50);
		}
		end_pocket = 800;
		restoreDefaults();
	}

	/**
	 * <h1>Player Mount</h1>
	 * <p>Makes player move at the same speed as obstacle it is currently one</p>
	 * <p>Will only work with Dry Turtles and Logs, all others trigger death animation</p>
	 * @param obstacle obstacle Object
	 */
	public void playerMount(obstacle obstacle){
		move(obstacle.getSpeed(),0);
	}

	/**
	 * <h1>Subtracting Points</h1>
	 * <p>Removes points from total score</p>
	 * @param points points accrued for doing an action
	 */
	public void subtractPoints(int points){
		score = (points <= points ? 0 : (points - points));
		changeScore = true;
	}

	/**
	 * <h1>Adding points</h1>
	 * <p>Adds points to total score</p>
	 * @param points points accrued for doing an action
	 */
	public void addPoints(int points) {
		score += points;
		changeScore = true;
	}

	/**
	 * <h1>Stopping Game</h1>
	 * <p>Sets endgame condition, how many ends need to be reached to send stop condition</p>
	 * @return Number of ends needed for end condition
	 */
	public boolean getStop() {
		return numEndsReached ==5;
	}

	public int getScore() {
		return score;
	}

	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	/**
	 * <h1>Death Animations</h1>
	 */
	public void waterDeath(){
		stop = true;
		List<Image> images = new ArrayList<>();
		Image cD1 = new Image("file:src/main/resources/cardeath1.png", size,size , true, true);
		Image cD2 = new Image("file:src/main/resources/cardeath2.png", size,size , true, true);
		Image cD3 = new Image("file:src/main/resources/cardeath3.png", size,size , true, true);

		images.addAll(Arrays.asList(cD1,cD2,cD3));

		DeathAnimator(images);


	}

	public void carDeath(){
		stop = true;
		List<Image> images = new ArrayList<>();
		Image wD1 = new Image("file:src/main/resources/waterdeath1.png", size,size , true, true);
		Image wD2 = new Image("file:src/main/resources/waterdeath2.png", size,size , true, true);
		Image wD3 = new Image("file:src/main/resources/waterdeath3.png", size,size , true, true);
		Image wD4 = new Image("file:src/main/resources/waterdeath4.png", size,size , true, true);

		images.addAll(Arrays.asList(wD1,wD2,wD3,wD4));

		DeathAnimator(images);

	}

	/**
	 * <h1>Death Animator</h1>
	 * <p>Sets transition timings for death animation and then resets to defaults.</p>
	 * <p>It also handles the subtraction of points for all deaths</p>
	 * @param images list of images for animation
	 * @see SequentialTransition
	 */
	public void DeathAnimator(List<Image> images) {
		final int milliseconds = 100;

		Transition DeathAnimation = animate(images, milliseconds);

		Transition AnimationPause = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(DeathAnimation, AnimationPause);

		animation.setOnFinished(event -> { restoreDefaults(); });

		animation.play();

		subtractPoints(50);
	}



	/* Movement */

	/**
	 * <h1>Handle Key Press</h1>
	 * <p>Handles the key press for WASD to move characters.</p>
	 * <p>Calls different movement animations depending on key pressed</p>
	 * @return EventHandler
	 * @see EventHandler
	 * @see KeyEvent
	 */
	public EventHandler<KeyEvent> getKeyPressedHandler(){
		EventHandler<KeyEvent> keyEventEventHandler = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if(!stop){
					final int milliseconds = 100;

					stop = true;

					if (keyEvent.getCode() == KeyCode.W){
						moveUp(milliseconds);
					}
					else if(keyEvent.getCode() == KeyCode.A){
						moveLeft(milliseconds);
					}else if(keyEvent.getCode() == KeyCode.S){
						moveDown(milliseconds);
					}else if(keyEvent.getCode() == KeyCode.D){
						moveRight(milliseconds);
					}
				}
			}

		};
		return keyEventEventHandler;
	}


	/**
	 * <h1>Movement</h1>
	 * <h2>Move Up</h2>
	 * <p>Uses both the default and up images to create the moving up animation</p>
	 * <p>Passes images to <b>Movement Animator</b></p>
	 * @param milliseconds Duration of animation
	 */
	public void moveUp(int milliseconds){
		final boolean endReached = getY() < end_pocket;
		List <Image> images = new ArrayList<>();
		move(0, -movement);
		Image firstMove = new Image("file:src/main/resources/froggerUpJump.png", size, size, true, true);
		Image secondMove = ActorImage;

		images.addAll(Arrays.asList(firstMove,secondMove));

		MovementAnimator(images,milliseconds,0,-movementX);
		if (endReached) {

			addPoints(10);

			end_pocket = getY();

		}

	}


	public void moveLeft(int milliseconds){
		List <Image> images = new ArrayList<>();
		move(-movementX, 0);
		Image firstMove = new Image("file:src/main/resources/froggerLeft.png", size, size, true, true);
		Image secondMove = new Image("file:src/main/resources/froggerLeftJump.png", size, size, true, true);


		images.addAll(Arrays.asList(firstMove,secondMove));

		MovementAnimator(images,milliseconds,-movementX,0);

	}

	public void moveDown(int milliseconds){
		List <Image> images = new ArrayList<>();
		move(0, movement);
		Image firstMove = new Image("file:src/main/resources/froggerDown.png", size, size, true, true);
		Image secondMove = new Image("file:src/main/resources/froggerDownJump.png", size, size, true, true);

		images.addAll(Arrays.asList(firstMove,secondMove));

		MovementAnimator(images,milliseconds,0,movement);

	}

	public void moveRight(int milliseconds){
		List <Image> images = new ArrayList<>();
		move(movementX, 0);
		Image firstMove = new Image("file:src/main/resources/froggerRight.png", size, size, true, true);
		Image secondMove = new Image("file:src/main/resources/froggerRightJump.png", size, size, true, true);
		images.addAll(Arrays.asList(firstMove,secondMove));

		MovementAnimator(images,milliseconds,movementX,0);

	}

	/**
	 * <h1>Movement Animator</h1>
	 * <p>Similar to death animation it uses a list of images to create an animation via transitions.</p>
	 *
	 * @param images List of images for animation
	 * @param milliseconds Duration of animation
	 * @param moveX Changing players X position
	 * @param moveY Changing players Y position
	 * @see Transition
	 */
	public void MovementAnimator(List<Image> images, int milliseconds, double moveX, double moveY) {

		Transition MovementAnimation = animate(images, milliseconds);

		MovementAnimation.setOnFinished(event -> move(moveX, moveY));

		Transition AnimationPause = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(MovementAnimation, AnimationPause);

		animation.setOnFinished(event -> { stop = false; });

		animation.play();
	}


	@Override
	public String getActorClassName() {
		return "Animal";
	}
}


