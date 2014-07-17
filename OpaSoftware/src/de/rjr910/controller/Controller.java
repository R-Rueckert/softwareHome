package de.rjr910.controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import de.rjr910.database.DatabaseManager;

public class Controller implements Initializable {
	
	@FXML private Button btnAnswer1;
	@FXML private Button btnAnswer2;
	@FXML private Button btnAnswer3;
	@FXML private Button btnAnswer4;
	DatabaseManager dbMan = new DatabaseManager();
	Connection conn = dbMan.getConnection();
	Statement stmt;
	@FXML private ImageView image;
	
	
	

	public void initialize(URL arg0, ResourceBundle arg1) {
		generateAnswers();

		
		
	}
	private void setImage(String path) {
		Image img = new Image(path);
		this.image.setImage(img);
	}
	private Statement getStatement() throws SQLException{
	
		this.stmt = conn.createStatement();
		return stmt;
		
	}
	
	private void generateAnswers(){
		ResultSet rs;
		
		try {
			stmt = getStatement();
			rs = stmt.executeQuery("SELECT * FROM DEUTSCH");
			rs.next();
			this.btnAnswer1.setText(rs.getString("ANSWER1"));
			this.btnAnswer2.setText(rs.getString("ANSWER2"));
			this.btnAnswer3.setText(rs.getString("ANSWER3"));
			this.btnAnswer4.setText(rs.getString("ANSWER4"));
			String path = rs.getString("IMAGEPATH");
			setImage(path);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	
	


}
