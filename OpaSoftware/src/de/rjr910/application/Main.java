package de.rjr910.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					"/de/rjr910/application/Menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(
			// new Image("de/rjr910/img/background/icon.png"));
					new Image("de/rjr910/img/background/robot3.jpg"));
			// primaryStage.setFullScreen(true);

			primaryStage.setTitle("Lebenslanges Lernen");
			primaryStage.show();
			primaryStage.setMaximized(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);

	}
}
