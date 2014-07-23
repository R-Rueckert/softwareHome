package de.rjr910.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import de.rjr910.audio.AudioManager;
import de.rjr910.audio.NoSoundAvailableException;
import de.rjr910.database.DatabaseManager;
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

	public void initialize(URL arg0, ResourceBundle arg1) {
		WordGame words = new WordGame(image,btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4,txtMessage);
		words.init();
		
		MathGame math = new MathGame(aufgabe);
		math.init();
			
		

	}




}
