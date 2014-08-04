package de.rjr910.audio;


public class AudioStoppedHandler implements Runnable{

	private GameInterface wg;
	
	public AudioStoppedHandler(GameInterface wg) {

		this.wg = wg;
	}

	@Override
	public void run() {
		wg.stopped();
	}

}
