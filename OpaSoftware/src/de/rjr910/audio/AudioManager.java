package de.rjr910.audio;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

	private Media hit;
	private MediaPlayer mediaPlayer;

	public void play(String sound, CallBackStopped c) throws NoSoundAvailableException {

		this.hit = new Media(new File(sound).toURI().toString());
		this.mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
		
		
		AudioStoppedHandler handler = new AudioStoppedHandler(c);
		
		mediaPlayer.setOnEndOfMedia(handler);
		
	
			
//		while(mediaPlayer.onEndOfMediaProperty() != null){
//			System.out.println(mediaPlayer.onEndOfMediaProperty());
//		}
//		mediaPlayer.setOnStopped(value);
//		while(mediaPlayer.getStatus() == Status.UNKNOWN ){
//			System.out.println(mediaPlayer.getStatus());
//		}

	}
	

	public void mediaStopped() {

		System.out.println("hier kann ich das stopped jetzt behandeln und das nächste Bild jetzt erst anzeigen");
		
	}
	
	

}
