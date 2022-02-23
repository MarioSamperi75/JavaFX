package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
// installation and configuration:
// https://www.youtube.com/watch?v=9XJicRt_FaI  00:40:22
// Creating scene with scene builder (Editor)
// if you want to edit fxml file with Scene Builder
// Right click on it - open with Scene Builder
public class AppMp3Player extends Application {
	@Override
	public void start(Stage stage) {
		try {
	
			Parent root = FXMLLoader.load(getClass().getResource("Mp3Player.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			// to avoid the error when closing the windows
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent arg0) {
					Platform.exit();
					System.exit(0);
					
					
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
