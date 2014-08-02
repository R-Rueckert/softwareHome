package de.rjr910.games.utilitiesMath;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import de.rjr910.audio.GameInterface;

public class MathHandler implements EventHandler<KeyEvent> {

	int count = 0;
	GameInterface mg;

	public MathHandler(GameInterface mg) {
		this.mg = mg;
	}

	@Override
	public void handle(KeyEvent event) {
		
		if(validateInput(event)){
			count++;
			mg.stopped();
		}

	}

	private boolean validateInput(KeyEvent event) {
		System.out.println(event.getCode());
				
		if(event.getCode().isDigitKey()){
			
			return true;
		}else {
			return false;
		}

	}

	public int getCount() {
		return count;
	}


}
