package de.rjr910.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller implements Initializable {
	
	@FXML private Button btnMenu;
	@FXML private Label txtBar;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	public void changeText(ActionEvent event){
		System.out.println("Click");
		txtBar.setText("Klappt");
//		btnMenu.setText("Haha");
	}

}
