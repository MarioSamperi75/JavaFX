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
public class AppKeyEvents extends Application {
	@Override
	public void start(Stage stage) {
		try {
			// some modification to handle key events
			FXMLLoader loader= new FXMLLoader(getClass().getResource("KeyEvents.fxml"));
			Parent root = loader.load();
			Controller_KeyEvents controller_KeyEvents = loader.getController();
			Scene scene = new Scene(root);
			
			//scene.setOnKeyPressed(new EventHandler<KeyEvent>() {  or with lambda...
				scene.setOnKeyPressed(event -> {
					switch (event.getCode()) {
					
					case DOWN:
						controller_KeyEvents.moveDown();
						break;
						
					case UP:
						controller_KeyEvents.moveUp();
						break;
						
					case LEFT:
						controller_KeyEvents.moveLeft();
						break;
						
					case RIGHT:
						controller_KeyEvents.moveRight();
						break;
						
					default:
						break;
					}
				});
			
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
