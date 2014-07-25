package de.rjr910.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import de.rjr910.games.MathGame;
import de.rjr910.games.WordGame;
import de.rjr910.games.utilitiesMath.NumFieldFX;

public class Controller implements Initializable {

	@FXML
	private Button btnAnswer1 = new Button();
	@FXML
	private Button btnAnswer2 = new Button();
	@FXML
	private Button btnAnswer3 = new Button();
	@FXML
	private Button btnAnswer4 = new Button();
	@FXML
	private Label txtMessage = new Label();
	@FXML
	private Label aufgabe = new Label();
	@FXML
	private ImageView image;
	@FXML
	private NumFieldFX solution = new NumFieldFX();

	public void initialize(URL arg0, ResourceBundle arg1) {
		WordGame words = new WordGame(image,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4,txtMessage);
		words.init();
		
		MathGame math = new MathGame(aufgabe,solution);
		math.init();
			
		

	}




}
