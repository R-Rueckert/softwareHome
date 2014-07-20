package de.rjr910.tests;

import de.rjr910.audio.AudioManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class AudioTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
			String sound = "src/de/rjr910/audio/files/elefant.mp3";
			AudioManager aMan = new AudioManager();
			aMan.play(sound);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
