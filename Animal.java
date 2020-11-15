package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class Animal extends Player {
	int points = 0;
	int numEndsReached = 0;
	double end_pocket = 800;
	boolean changeScore = false;
//	boolean noMove = false;
//	boolean carDeath = false;
//	boolean waterDeath = false;
//	int imgSize = 40;
//	int carD = 0;

//	private boolean second = false;

//	boolean stop = false;


//	ArrayList<End> inter = new ArrayList<End>();

	public Animal(String imageLink, int size, int xPos, int yPos) {
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


/*
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		// Starting Pos
		setX(300);
		setY(679.8+movement);
		//

		/* Adding score
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				setOnKeyReleased(new EventHandler<KeyEvent>() {
					public void handle(KeyEvent event) {
						if (noMove) {
						} else {
							if (event.getCode() == KeyCode.W) {
								if (getY() < end_pocket) {
									changeScore = true;
									end_pocket = getY();
									points += 10;
								}
								move(0, -movement);
								setImage(FrogUp);
								second = false;
							} else if (event.getCode() == KeyCode.A) {
								move(-movementX, 0);
								setImage(FrogL);
								second = false;
							} else if (event.getCode() == KeyCode.S) {
								move(0, movement);
								setImage(FrogD);
								second = false;
							} else if (event.getCode() == KeyCode.D) {
								move(movementX, 0);
								setImage(FrogR);
								second = false;
							}
						}
					}

				});
			}
		});
		*/

	/* Deaths */

//	public void act(long now) {
		/* Out of bounds */
//		}
		/*
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		/* ----------------------------- */
		/*
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}

		/* Out of bounds
		if (getX()>600) {
			move(-movement*2, 0);
		}
		/* -----------------------------*/
		/* Intersecting with other objects (riding)
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			end_pocket =800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}

	/* Death Animations*/
	public void waterDeath(){
		Image cD1 = new Image("file:src/p4_group_8_repo/cardeath1.png", size,size , true, true);
		Image cD2 = new Image("file:src/p4_group_8_repo/cardeath2.png", size,size , true, true);
		Image cD3 = new Image("file:src/p4_group_8_repo/cardeath3.png", size,size , true, true);


		List<Image> images = new ArrayList<>();
		images.add(cD1);
		images.add(cD2);
		images.add(cD3);

		DeathAnimationPlayer(images,1000);
		points -= 50;

	}

	public void carDeath(){
		Image wD1 = new Image("file:src/p4_group_8_repo/waterdeath1.png", size,size , true, true);
		Image wD2 = new Image("file:src/p4_group_8_repo/waterdeath2.png", size,size , true, true);
		Image wD3 = new Image("file:src/p4_group_8_repo/waterdeath3.png", size,size , true, true);
		Image wD4 = new Image("file:src/p4_group_8_repo/waterdeath4.png", size,size , true, true);

		List<Image> images = new ArrayList<>();
		images.add(wD1);
		images.add(wD2);
		images.add(wD3);
		images.add(wD4);

		DeathAnimationPlayer(images,1000);
		points -= 50;
	}

	public void DeathAnimationPlayer(List<Image> images, int milliseconds) {

		Transition DeathAnimation = animate(images, milliseconds);

		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(DeathAnimation, PauseAfterAnimation);

		animation.setOnFinished(event -> { restoreDefaults(); });

		animation.play();
	}

	/* Handling player interactions */
	// This will handle death animations, score upkeep when reaching an End and the interaction
	// between player and logs + turtles
	public void handleEnd(End end){
		if(end.isActivated()){
			end.deactivate();
			numEndsReached--;
			points -= 50;
			changeScore = true;
		}
		else{
			end.activate();
			numEndsReached++;
			points += 50;
			changeScore = true;
		}
		restoreDefaults();
	}
	public void playerMount(Obstacle obstacle){
		move(obstacle.getSpeed(),0);
	}
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

	public void handlePlayerInteractions(Actor actor){
		final String actorName = actor.getActorClassName();

		// If the current obstacle interaction class name is equal to either of these cases the boolean will become true
		final boolean carDeath = actorName.equalsIgnoreCase("Car");
		final boolean waterDeath = actorName.equalsIgnoreCase("WetTurtle") && ( (WetTurtle) actor ).isSunk() ;

		// If player interacted with an end goal boolean will become true
		final boolean endReached = actorName.equalsIgnoreCase("Final");

		if(carDeath){ 	// If car interaction
			carDeath(); // Play animation
			return; 	// Onto next interaction
		}
		else if(waterDeath){
			waterDeath();
			return;
		}
		else if(endReached){
			handleEnd((End) actor);
			return;
		}

		if(actor instanceof Obstacle){ //If player is intersecting with (stands on) any actor of type obstacle (Turtle or Log)
			playerMount((Obstacle) actor); // The player will move at the same speed as that obstacle in the same direction
		}


	}
	/* Movement */

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
						moveDown(milliseconds);
					}
				}
			}

		};
		return keyEventEventHandler;
	}

	public void moveUp(int milliseconds){
		move(0, -movement);
		Image firstMove = new Image("file:src/p4_group_8_repo/froggerUp.png", size, size, true, true);
		Image secondMove = new Image("file:src/p4_group_8_repo/froggerUpJump.png", size, size, true, true);

		List <Image> images = new ArrayList<>();
		images.add(firstMove);
		images.add(secondMove);

		MovementAnimationPlay(images,milliseconds,movementX,0);

	}


	public void moveLeft(int milliseconds){
		move(-movementX, 0);
		Image firstMove = new Image("file:src/p4_group_8_repo/froggerLeft.png", size, size, true, true);
		Image secondMove = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", size, size, true, true);

		List <Image> images = new ArrayList<>();
		images.add(firstMove);
		images.add(secondMove);

		MovementAnimationPlay(images,milliseconds,-movementX,0);

	}

	public void moveDown(int milliseconds){
		move(0, movement);
		Image firstMove = new Image("file:src/p4_group_8_repo/froggerDown.png", size, size, true, true);
		Image secondMove = new Image("file:src/p4_group_8_repo/froggerDownJump.png", size, size, true, true);

		List <Image> images = new ArrayList<>();
		images.add(firstMove);
		images.add(secondMove);

		MovementAnimationPlay(images,milliseconds,0,movement);

	}

	public void moveRight(int milliseconds){
		move(movementX, 0);
		Image firstMove = new Image("file:src/p4_group_8_repo/froggerRight.png", size, size, true, true);
		Image secondMove = new Image("file:src/p4_group_8_repo/froggerRightJump.png", size, size, true, true);

		List <Image> images = new ArrayList<>();
		images.add(firstMove);
		images.add(secondMove);

		MovementAnimationPlay(images,milliseconds,movementX,0);

	}

	public void MovementAnimationPlay(List<Image> images, int milliseconds, double moveX, double moveY) {

		Transition MovementAnimation = animate(images, milliseconds);

		MovementAnimation.setOnFinished(event -> move(moveX, moveY));

		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));

		SequentialTransition animation = new SequentialTransition(MovementAnimation, PauseAfterAnimation);

		animation.setOnFinished(event -> { stop = false; });

		animation.play();
	}
	public boolean getStop() {
		return numEndsReached ==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	@Override
	public String getActorClassName() {
		return "Animal";
	}
}
