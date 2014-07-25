package de.rjr910.games;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MathGame {

	private Label generatedQuestion;
	private TextField inputSolution;
	private int mathSolution;
	int count= 0;
	
	public MathGame(Label aufgabe, TextField solution) {
		this.generatedQuestion = aufgabe;
		this.inputSolution = solution;
		inputSolution.setOnKeyReleased(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				count++;
				if(mathSolution < 10 && count <2){
					checkResult();
				}
			}
		});
	}
	
	public void init(){
		generatedQuestion.setText(generateMathQuestion(1,20));
		checkResult();
	}

	private boolean checkResult() {
		
		
		if(mathSolution < 10 && mathSolution >0){
			if(mathSolution == Integer.parseInt(inputSolution.getText())){
				System.out.println("True");
				return true;
			}else{
				return false;
			}
		}else{
			
		}
		return false;
		// TODO Auto-generated method stub
		
	}



	private String generateMathQuestion(int low, int high) {
		String operator = chooseOperator();
		int rand1 = generateRandom(low, high);
		int rand2 = generateRandom(low, high);
		int mathSolution = calculateSolution(rand1,rand2,operator);
		if(rand1 > rand2){
			return rand1+ " " + operator +" "+ rand2 + " = ";
		}else{
			return rand2+ " " + operator +" "+ rand1 + " = ";
		}
		
		
		
	}
	
	private String chooseOperator() {

		int rand = generateRandom(1,2);
		switch(rand){
			case 1: 
				return "+";
			case 2:
				return "-";
			case 3:
				return ":";
			case 4:
				return "x";
		}
		return null;
	}

	private int calculateSolution(int a, int b, String op) {

		switch(op){
		case "+":
			return a + b;
		case "-":
			return a - b;
		case ":":
			return a/b;
		case "x":
			return a*b;
		}
		
		return 0;
	}

	private int generateRandom(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}
	

}
