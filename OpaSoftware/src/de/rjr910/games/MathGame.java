package de.rjr910.games;


import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import de.rjr910.audio.GameInterface;
import de.rjr910.games.utilitiesMath.Animation;
import de.rjr910.games.utilitiesMath.MathHandler;

public class MathGame implements GameInterface {

	private Label generatedQuestion;
	private TextField inputSolution;
	private int mathSolution;
	private MathHandler myMathHandler;
	private Button btnNewMath;
	int count = 0;
	private Label response;
	private Animation ani = new Animation();

	public MathGame(Label aufgabe, TextField solution, Label mathResponse,
			Button btnNewMath) {
		this.generatedQuestion = aufgabe;
		this.inputSolution = solution;
		this.response = mathResponse;
		this.btnNewMath = btnNewMath;

	}

	public void init() {
		btnNewMath.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Neue Aufgabe gefordert");
				generatedQuestion.setText(generateMathQuestion(1, Admin.getMaxNumber()));

			}
		});
		response.setVisible(false);
		myMathHandler = new MathHandler(this);
		
		inputSolution.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> arg0,String arg1, String newValue) {
				if(!isNumeric(newValue)){
				     inputSolution.setText("");
				} else if(newValue.length() >= 4){
				     inputSolution.setText(newValue.substring(0, 4));
				}
			}
		});
		inputSolution.setOnKeyReleased(myMathHandler);
		generatedQuestion.setText(generateMathQuestion(1, Admin.getMaxNumber()));
	}

	private boolean isNumeric(String str) {
	   return str.matches("-?\\d+(.\\d+)?");
	}
	
	public boolean checkResult() {

		if (mathSolution < 10) {
			System.out.println("Eingegebene Lösung = "
					+ inputSolution.getText());
			if (mathSolution == Integer.parseInt(inputSolution.getText())) {
				System.out.println("Korrekt Einstellig");
				return true;
			}
		} else if (mathSolution >= 10) {
			System.out.println("Eingegebene Lösung = "
					+ inputSolution.getText());
			if (mathSolution == Integer.parseInt(inputSolution.getText())) {
				System.out.println("Korrekt Zweistellig");
				return true;
			}

		}
		return false;
	}

	private String generateMathQuestion(int low, int high) {
		String operator = chooseOperator();
		inputSolution.setText("");
		// response.setText("");
		int rand1 = generateRandom(low, high);
		int rand2 = generateRandom(low, high);
		if (rand1 > rand2) {
			mathSolution = calculateSolution(rand1, rand2, operator);
			return rand1 + " " + operator + " " + rand2 + " = ";
		} else {
			mathSolution = calculateSolution(rand2, rand1, operator);
			return rand2 + " " + operator + " " + rand1 + " = ";
		}

	}

	private String chooseOperator() {

		int rand = generateRandom(1, 2);
		switch (rand) {
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

		switch (op) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case ":":
			return a / b;
		case "x":
			return a * b;
		}

		return 0;
	}

	private int generateRandom(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}

	@Override
	public void stopped() {
		if (checkResult()) {
			// response.setText("Ja");
			ani.fadeIn(response,this);
		}

	}

	@Override
	public void callNext() {
		this.init();
	}

}
