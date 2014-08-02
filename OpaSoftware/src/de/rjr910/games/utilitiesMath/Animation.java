package de.rjr910.games.utilitiesMath;

import de.rjr910.audio.GameInterface;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Animation {

	
	
	public void fadeIn(Label label, final GameInterface c) {

		FadeTransition fadeTransition = new FadeTransition(
				Duration.millis(1000), label);
		label.setVisible(true);
		fadeTransition.setFromValue(0.0);
		fadeTransition.setToValue(1.0);
		fadeTransition.play();
		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Animation played");
				//Call new Game here
				c.callNext();
			}
		});
	}

	public void fadeOut(Label label) {

		FadeTransition fadeTransition = new FadeTransition(
				Duration.millis(0), label);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		fadeTransition.play();

	}
}
