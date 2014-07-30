package de.rjr910.games;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import de.rjr910.audio.CallBackStopped;
import de.rjr910.games.utilitiesMath.Animation;
import de.rjr910.games.utilitiesMath.MathHandler;

public class MathGame implements CallBackStopped {

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
				generatedQuestion.setText(generateMathQuestion(1, 20));

			}
		});
//		ani.fadeOut(response);
		response.setVisible(false);
		myMathHandler = new MathHandler(this);
		inputSolution.setOnKeyReleased(myMathHandler);
//		inputSolution.positionCaret(1);
		generatedQuestion.setText(generateMathQuestion(1, 20));
		// checkResult();
	}

	public boolean checkResult() {

		System.out.println("get Count" + myMathHandler.getCount());
		System.out.println("Errechnete Lösung = " + mathSolution);
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
