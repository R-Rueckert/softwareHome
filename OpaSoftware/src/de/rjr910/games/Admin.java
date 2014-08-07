package de.rjr910.games;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Admin {

	private TextField maxNumberInputField = new TextField();
	private static int mathMaxNumber = 20;

	public Admin(TextField maxNumberInput) {
		this.maxNumberInputField = maxNumberInput;

		maxNumberInputField.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				setMaxNumber(Integer.parseInt(maxNumberInputField.getText()));
			}
		});

		maxNumberInputField.textProperty().addListener(
				new ChangeListener<String>() {
					public void changed(ObservableValue<? extends String> arg0,
							String arg1, String newValue) {
						if (!isNumeric(newValue)) {
							maxNumberInputField.setText("");
						} else if (newValue.length() >= 3) {
							maxNumberInputField.setText(newValue
									.substring(0, 3));
						}
					}
				});
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(.\\d+)?");
	}

	public static int getMaxNumber() {
		return mathMaxNumber;
	}

	public void setMaxNumber(int maxNumber) {

		mathMaxNumber = maxNumber;
	}

}
