package application;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// multi-layer structure: Stage - Scene - SceneGraph - nodes (root node and the others)
// you must have at least a root node to create a scene

// we implement the start method that we inherit from Application
// we inherit also the Launch static method
// it calls the start method behind the scenes

public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	// we create a stage - we get already one as parameter
	//  we create a root
	@Override
	public void start(Stage stage) throws Exception {
		
		// if you want to create another stage:
		// Stage stage = new Stage();
		
		// there is many kind of root, Group is very basic
		Group root = new Group();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
		
		
	}
}
