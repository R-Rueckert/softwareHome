package de.rjr910.games;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import de.rjr910.audio.AudioManager;
import de.rjr910.audio.CallBackStopped;
import de.rjr910.audio.NoSoundAvailableException;
import de.rjr910.database.DatabaseManager;

public class WordGame implements CallBackStopped{

	private List<Button> btnList = new ArrayList<Button>();
	@FXML
	private Button btnAnswer1;
	@FXML
	private Button btnAnswer2;
	@FXML
	private Button btnAnswer3;
	@FXML
	private Button btnAnswer4;

	@FXML
	private Label txtMessage;
	DatabaseManager dbMan = new DatabaseManager();
	Connection conn = dbMan.getConnection();
	Statement stmt;
	private String solution;
	private String sound;
	@FXML
	private ImageView image;
	private AudioManager aMan = new AudioManager();
	
	public WordGame(ImageView image,Button btnAnswer1,Button btnAnswer2, Button btnAnswer3,Button btnAnswer4,Label txtMessage){
		this.btnAnswer1 = btnAnswer1;
		this.btnAnswer2 = btnAnswer2;
		this.btnAnswer3 = btnAnswer3;
		this.btnAnswer4 = btnAnswer4;
		this.image = image;
		this.txtMessage = txtMessage;
		
	}


	public void init(){
		btnList.add(btnAnswer1);
		btnList.add(btnAnswer2);
		btnList.add(btnAnswer3);
		btnList.add(btnAnswer4);
		generateAnswers();
	}
	
	private void setImage(String path) {
		Image img = new Image(path);
		this.image.setImage(img);
		image.getStyleClass().add("imageDeutsch");
	}

	private Statement getStatement() throws SQLException {

		this.stmt = conn.createStatement();
		return stmt;

	}

	public void generateAnswers() {
		ResultSet rs;
		int maxEntries = getMaxEntries("Deutsch");
		int entry = getRandomNumber(maxEntries);

		for (Button b : btnList) {
			b.getStyleClass().remove("buttonRed");
			b.getStyleClass().remove("buttonGreen");
			b.getStyleClass().remove("hide");

		}

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
			// System.out.println(sound);
			setImage(path);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnAnswer1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer1)) {
//					waitUntilNext(5000);
//					generateAnswers();
				}
			}
		});
		btnAnswer2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer2)) {
//					waitUntilNext(5000);
//					generateAnswers();
				}
			}
		});
		btnAnswer3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer3)) {
//					waitUntilNext(5000);
//					generateAnswers();
				}
			}
		});
		btnAnswer4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (checkResult(btnAnswer4)) {
//					waitUntilNext(5000);
//					generateAnswers();
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
		showMessage(btnAnswer);
		try {
			aMan.play(sound,this);
//			aMan.holdUntilAudioStopped();
		} catch (NoSoundAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showMessage(Button btnAnswer) {
		txtMessage.setText(btnAnswer.getText());
		for (Button b : btnList) {
			b.getStyleClass().add("hide");
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


	@Override
	public void stopped() {
		generateAnswers();	
	}

	
}
