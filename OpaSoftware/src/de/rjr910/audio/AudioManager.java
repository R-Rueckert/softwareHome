package de.rjr910.audio;

import java.io.File;

import de.rjr910.games.WordGame;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioManager {

	Media hit;
	MediaPlayer mediaPlayer;
	boolean audioPlayed = false;
	

	public void play(String sound) throws NoSoundAvailableException {

		this.hit = new Media(new File(sound).toURI().toString());
		this.mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
		
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				audioPlayed = true;
			}
		});
//		while(mediaPlayer.onEndOfMediaProperty() != null){
//			System.out.println(mediaPlayer.onEndOfMediaProperty());
//		}
//		mediaPlayer.setOnStopped(value);
//		while(mediaPlayer.getStatus() == Status.UNKNOWN ){
//			System.out.println(mediaPlayer.getStatus());
//		}

	}
	
	public boolean getAudioPlayed(){
		return audioPlayed;
	}
	

}
