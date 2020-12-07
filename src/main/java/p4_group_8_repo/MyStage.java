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

	public MyStage() {
		this.musicPath = "src/main/resources/Frogger Main Song Theme (loop).mp3";
	}

	public void playMusic() {
		String musicFile = musicPath;
//		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";
//		String musicFile = "src/p4_group_8_repo/Crazy-Frog-Axel-f.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	public void stopMusic() {
		mediaPlayer.stop();
	}

}
