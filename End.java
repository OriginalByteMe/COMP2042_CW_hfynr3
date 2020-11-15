package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends StaticActor{
	boolean activated = false;


	public End(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size, xPos, yPos);

	}

	@Override
	public String getActorClassName() {
		return null;
	}

	public void activate(){
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
