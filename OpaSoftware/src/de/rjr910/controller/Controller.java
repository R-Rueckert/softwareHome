package de.rjr910.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import de.rjr910.audio.AudioManager;
import de.rjr910.audio.NoSoundAvailableException;
import de.rjr910.database.DatabaseManager;

public class Controller implements Initializable {

	@FXML
	private Button btnAnswer1 = new Button();
	@FXML
	private Button btnAnswer2 = new Button();
	@FXML
	private Button btnAnswer3 = new Button();
	@FXML
	private Button btnAnswer4 = new Button();
	DatabaseManager dbMan = new DatabaseManager();
	Connection conn = dbMan.getConnection();
	Statement stmt;
	private String solution;
	private String sound;
	@FXML
	private ImageView image;
	private AudioManager aMan = new AudioManager();

	public void initialize(URL arg0, ResourceBundle arg1) {
		generateAnswers();

	}

	private void setImage(String path) {
		Image img = new Image(path);
		this.image.setImage(img);
	}

	private Statement getStatement() throws SQLException {

		this.stmt = conn.createStatement();
		return stmt;

	}

	private void generateAnswers() {
		ResultSet rs;
		int maxEntries = getMaxEntries("Deutsch");
		int entry = getRandomNumber(maxEntries);
		this.btnAnswer1.getStyleClass().remove("buttonRed");
		this.btnAnswer1.getStyleClass().remove("buttonGreen");
		this.btnAnswer2.getStyleClass().remove("buttonRed");
		this.btnAnswer2.getStyleClass().remove("buttonGreen");
		this.btnAnswer3.getStyleClass().remove("buttonRed");
		this.btnAnswer3.getStyleClass().remove("buttonGreen");
		this.btnAnswer4.getStyleClass().remove("buttonRed");
		this.btnAnswer4.getStyleClass().remove("buttonGreen");

		try {
			stmt = getStatement();
			rs = stmt.executeQuery("SELECT * FROM DEUTSCH");
			// System.out.println("Entries DB= " + maxEntries);
			System.out.println("DB-ID " + entry);

			for (int i = 0; i < entry; i++) {
				rs.next();
			}
			this.btnAnswer1.setText(rs.getString("ANSWER1").toUpperCase());
			this.btnAnswer2.setText(rs.getString("ANSWER2").toUpperCase());
			this.btnAnswer3.setText(rs.getString("ANSWER3").toUpperCase());
			this.btnAnswer4.setText(rs.getString("ANSWER4").toUpperCase());
			solution = rs.getString("SOLUTION").toUpperCase();
			String path = rs.getString("IMAGEPATH");
			sound = rs.getString("AUDIOPATH");
			System.out.println(sound);
			setImage(path);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnAnswer1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				if (checkResult(btnAnswer1)) {
					generateAnswers();
				}
			}
		});
		btnAnswer2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer2)) {
					generateAnswers();
				}
			}
		});
		btnAnswer3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer3)) {
					generateAnswers();
				}
			}
		});
		btnAnswer4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer4)) {
					generateAnswers();
				}
			}
		});

	}

	private int getRandomNumber(int maxEntries) {

		int rand = (int) (Math.random() * maxEntries) + 1;
		return rand;
	}

	private int getMaxEntries(String table) {

		int entries = -1;
		ResultSet idMax;
		Statement st2 = null;

		try {
			st2 = getStatement();
			idMax = st2.executeQuery("select nvl(max(id),0) max_id from "
					+ table);
			if (idMax.next()) {
				entries = idMax.getInt("max_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entries;
	}

	private boolean checkResult(Button btnAnswer) {
		System.out.println(solution);
		if (btnAnswer.getText().toUpperCase().equals(solution)) {
			// System.out.println("Korrekt");
			winMessage(btnAnswer);
			return true;
		} else {
			// System.out.println("Falsch");
			loseMessage(btnAnswer);

			return false;
		}

	}

	private void loseMessage(Button btnAnswer) {
		btnAnswer.getStyleClass().add("buttonRed");

	}

	private void winMessage(Button btnAnswer) {
		btnAnswer.getStyleClass().add("buttonGreen");
		if (sound != null) {
			try {
				aMan.play(sound);
			} catch (NoSoundAvailableException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unused")
	private void waitUntilNext(int sleepTime) {

		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
