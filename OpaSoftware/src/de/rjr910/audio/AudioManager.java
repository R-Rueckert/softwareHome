package de.rjr910.audio;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

	Media hit;
	MediaPlayer mediaPlayer;

	public void play(String sound) throws NoSoundAvailableException {

		this.hit = new Media(new File(sound).toURI().toString());
		this.mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
	
			
//		while(mediaPlayer.onEndOfMediaProperty() != null){
//			System.out.println(mediaPlayer.onEndOfMediaProperty());
//		}
//		mediaPlayer.setOnStopped(value);
//		while(mediaPlayer.getStatus() == Status.UNKNOWN ){
//			System.out.println(mediaPlayer.getStatus());
//		}

	}
	

}
