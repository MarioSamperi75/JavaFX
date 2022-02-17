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
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
	
			Parent root = FXMLLoader.load(getClass().getResource("css.fxml"));
			Scene scene = new Scene(root);
			
			// connecting a scene to css file
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			String css =this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
