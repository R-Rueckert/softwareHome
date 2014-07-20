package de.rjr910.audio;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

	Media hit;

	public void play(String sound) throws NoSoundAvailableException {

		this.hit = new Media(new File(sound).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();

	}

}
