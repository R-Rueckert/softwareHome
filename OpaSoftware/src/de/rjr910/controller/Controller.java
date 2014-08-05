package de.rjr910.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import de.rjr910.games.Admin;
import de.rjr910.games.MathGame;
import de.rjr910.games.WordGame;

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
	private TextField solution = new TextField();
	@FXML
	private Label mathResponse = new Label();
	@FXML
	private Button btnNewMath = new Button();
//	@FXML
//	private TabPane gameTabPane = new TabPane();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Admin adminPanel = new Admin();
		adminPanel.setMaxNumber(15);
		
		WordGame words = new WordGame(image,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4,txtMessage);
		words.init();
		
		MathGame math = new MathGame(aufgabe,solution,mathResponse,btnNewMath);
		math.init();
			
		
		

	}




}
