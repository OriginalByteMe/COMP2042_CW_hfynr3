package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundImage extends ImageView {

	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
