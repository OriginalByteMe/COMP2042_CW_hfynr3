package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends StaticActor{


	public Digit(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size, xPos, yPos);
	}

	/**
	 * <h1>Setting digit number</h1>
	 * <p>Using n we can decide which digit to display at a time</p>
	 * @param n number for digit
	 */
	public void setDigit(int n){
		Image digitImage = new Image("file:src/main/resources/" + n +".png", size, size, true, true);
		setImage(digitImage);
	}

	@Override
	public String getActorClassName() {
		return "Digit";
	}

	
}
