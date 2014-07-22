package de.rjr910.games;

import java.util.Random;

import javafx.scene.control.Label;

public class MathGame {

	private Label generatedQuestion;
	
	public MathGame(Label aufgabe) {
		this.generatedQuestion = aufgabe;
		
	}
	
	public void init(){
		generatedQuestion.setText(generateMathQuestion(1,20));
	}

	private String generateMathQuestion(int low, int high) {
		int rand1 = generateRandom(low, high);
		int rand2 = generateRandom(low, high);
		
		
		
		return rand1 + " + " + rand2 + " = ";
	}
	
	public static int generateRandom(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}

}
