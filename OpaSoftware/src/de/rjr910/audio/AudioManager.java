package de.rjr910.audio;

import java.io.File;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

//	private Media hit;
	private Media media;
	private MediaPlayer mediaPlayer;

	public void play(String sound, GameInterface c){

//		this.hit = new Media(new File("src////"+sound).toURI().toString());
//		URL resource = getClass().getResource("files/elefant.mp3");
		URL resource = getClass().getResource(sound);
		
//		this.hit = new Media(toString());
//		this.hit = new Media("src////"+sound);
		
		this.media = new Media(resource.toString());
		this.mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		
//		URL resource = getClass().getResource("files/elefant.mp3");
//		AudioClip clip = new AudioClip(resource.toString());
//		clip.play();
		
		
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
