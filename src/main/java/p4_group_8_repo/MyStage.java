package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	private String musicPath;
	public MyStage(String musicPath) {
		this.musicPath = musicPath;
	}


	public MyStage(){
		musicPath = "src/main/resources/Frogger Main Song Theme (loop).mp3";
	}

	/**
	 * Sets the background music for the stage
	 */
	public void playMusic() {


//		String musicFile = "src/p4_group_8_repo/Crazy-Frog-Axel-f.mp3";

		Media sound = new Media(new File(musicPath).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	public void stopMusic() {
//		mediaPlayer.stop();
		try {
			mediaPlayer.stop();
			if (mediaPlayer.getError() == null) {
				mediaPlayer.setOnError(new Runnable() {
					public void run() {
						// Handle asynchronous error in Media object.
					}
				});
				try {
					mediaPlayer = new MediaPlayer(mediaPlayer.getMedia());
					if (mediaPlayer.getError() == null) {
						mediaPlayer.setOnError(new Runnable() {
							public void run() {
								// Handle asynchronous error in MediaPlayer object.
							}
						});
					} else {
						// Handle synchronous error creating MediaPlayer.
					}
				} catch (Exception mediaPlayerException) {
					// Handle exception in MediaPlayer constructor.
				}
			} else {
				// Handle synchronous error creating Media.
			}
		} catch (Exception mediaException) {
			// Handle exception in Media constructor.
		}

	}


}
