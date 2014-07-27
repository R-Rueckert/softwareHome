package de.rjr910.games.utilitiesMath;

import javafx.event.Event;
import javafx.event.EventHandler;
import de.rjr910.audio.CallBackStopped;

public class MathHandler implements EventHandler<Event> {

	int count = 0;
	CallBackStopped mg;

	public MathHandler(CallBackStopped mg) {
		this.mg = mg;
	}

	@Override
	public void handle(Event event) {
//		System.out.println("Key typed");

		count++;
		mg.stopped();

	}

	public int getCount() {
		return count;
	}

}
