package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
// installation and configuration:
// https://www.youtube.com/watch?v=9XJicRt_FaI  00:40:22
// Creating scene with scene builder (Editor)
// if you want to edit fxml file with Scene Builder
// Right click on it - open with Scene Builder
public class AppLogout extends Application {
	@Override
	public void start(Stage stage) {
		try {
	
			Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			// to activate the alarm on pressing x
			stage.setOnCloseRequest((event) -> {
				event.consume(); // that avoid the logout if we choose 'cancel'
				logout(stage);
				});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout (Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("logout");
		alert.setHeaderText("You are about to log out.");
		alert. setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("you successfully logged out!!!");
			stage.close();	
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
