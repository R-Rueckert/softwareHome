package de.rjr910.games;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
				generatedQuestion.setText(generateMathQuestion(1,Admin
						.getMaxNumber()));

			}
		});
		response.setVisible(false);
		myMathHandler = new MathHandler(this);

		inputSolution.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String newValue) {
				if (!isNumeric(newValue)) {
					inputSolution.setText("");
				} else if (newValue.length() >= 4) {
					inputSolution.setText(newValue.substring(0, 4));
				}
			}
		});
		inputSolution.setOnKeyReleased(myMathHandler);
		generatedQuestion.setText(generateMathQuestion(1,Admin.getMaxNumber()));
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(.\\d+)?");
	}

	public boolean checkResult() {

		if (mathSolution < 10) {
			System.out.println("Eingegebene Lösung = "
					+ inputSolution.getText());
			if (mathSolution == Integer.parseInt(inputSolution.getText())) {
				// System.out.println("Korrekt Einstellig");
				return true;
			}
		} else if (mathSolution >= 10) {
			System.out.println("Eingegebene Lösung = "
					+ inputSolution.getText());
			if (mathSolution == Integer.parseInt(inputSolution.getText())) {
				// System.out.println("Korrekt Zweistellig");
				return true;
			}

		}
		return false;
	}

	private String generateMathQuestion(int low, int high) {
		String operator = chooseOperator();
		inputSolution.setText("");
//		int low = 1;
//		int high = generateHigh(operator, highestResult);
		int rand1 = generateRandom(low, high);
		int rand2 = generateRandom(low, high);

		if (operator.equals(":")) {
			while (rand1 % rand2 != 0 || rand2 % rand1 != 0) {
				rand2 = generateRandom(low, high);
				rand1 = generateRandom(low, high);
			}
		}

		if (rand1 > rand2) {
			if (operator.equals("+") || operator.equals("-")) {
				calculateSolution(rand1, rand2, operator);
			} else if (operator.equals(":")) {
				calculateSolution(rand1, rand2, operator);
			} else {
				calculateSolution(rand1, rand2, operator);
			}
			System.out.println("Lösung= " + mathSolution);
			return rand1 + " " + operator + " " + rand2 + " = ";
		} else {
			if (operator.equals("+") || operator.equals("-")) {
				calculateSolution(rand2, rand1, operator);
			} else if (operator.equals(":")) {
				calculateSolution(rand2, rand1, operator);
			} else {
				calculateSolution(rand2, rand1, operator);
			}
			System.out.println("Lösung= " + mathSolution);
			return rand2 + " " + operator + " " + rand1 + " = ";
		}

	}

	private int generateHigh(String operator, int highestResult) {

		switch (operator) {
		case "+":
			return highestResult / 2;
		case "-":
			return highestResult * 2;
		case ":":
			return highestResult * highestResult;
		case "x":
			return highestResult / highestResult;

		}
		return 0;
	}

	private String chooseOperator() {

		int rand = generateRandom(1, 2);
		switch (rand) {
		case 1:
			return "+";
		case 2:
			return "-";
		case 3:
			return "x";
		case 4:
			return ":";
		}
		return null;
	}

	private void calculateSolution(int a, int b, String op) {

		System.out.println("A= " + a + " B= " + b + " op= " + op);

		switch (op) {
		case "+":
			mathSolution = a + b;
			break;
		case "-":
			mathSolution = a - b;
			break;
		case ":":
			mathSolution = a / b;
			break;
		case "x":
			mathSolution = a * b;
			break;
		}

	}

	private int generateRandom(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}

	@Override
	public void stopped() {
		if (checkResult()) {
			ani.fadeIn(response, this);
		}

	}

	@Override
	public void callNext() {
		this.init();
	}

}
