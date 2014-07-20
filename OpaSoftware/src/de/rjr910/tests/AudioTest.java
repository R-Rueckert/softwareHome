package de.rjr910.tests;

import java.net.URL;

import de.rjr910.audio.AudioManager;

public class AudioTest {

	public static void main(String[] args) {

		String sound = "src/de/rjr910/audio/files/elefant.mp3";
		
		
		AudioManager aMan = new AudioManager();
		aMan.play(sound);
	}

}
