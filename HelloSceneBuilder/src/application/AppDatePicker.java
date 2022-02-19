package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
// installation and configuration:
// https://www.youtube.com/watch?v=9XJicRt_FaI  00:40:22
// Creating scene with scene builder (Editor)
// if you want to edit fxml file with Scene Builder
// Right click on it - open with Scene Builder
public class AppDatePicker extends Application {
	@Override
	public void start(Stage stage) {
		try {
	
			Parent root = FXMLLoader.load(getClass().getResource("DatePicker.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
