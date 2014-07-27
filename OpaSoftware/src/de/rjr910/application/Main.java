package de.rjr910.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/de/rjr910/application/Menu.fxml"));
			root.setStyle("-fx-background-image: url('de/rjr910/img/background/board.jpg')");  
			Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
			Scene scene = new Scene(root,screenBounds.getHeight(),screenBounds.getWidth());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("de/rjr910/img/background/robot3.png"));
//			primaryStage.setFullScreen(true);
			
			primaryStage.setTitle("Lebenslanges Lernen");
			primaryStage.show();
			primaryStage.setMaximized(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
		
	}
}
