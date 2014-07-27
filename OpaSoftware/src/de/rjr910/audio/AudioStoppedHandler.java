package de.rjr910.audio;


public class AudioStoppedHandler implements Runnable{

	private CallBackStopped wg;
	
	public AudioStoppedHandler(CallBackStopped wg) {

		this.wg = wg;
	}

	public void run() {
		System.out.println("stopped");
		wg.stopped();
		
	}

}
