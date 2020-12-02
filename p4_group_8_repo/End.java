package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends StaticActor{
	private boolean activated = false;


	public End(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size, xPos, yPos);

	}

	@Override
	public String getActorClassName() {
		return "End";
	}

	public void activate(){
		setImage(new Image("file:src/Resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	public void deactivate(){
		setImage(ActorImage);
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}




}
