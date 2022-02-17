package application;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

// multi-layer structure: Stage - Scene - SceneGraph - nodes (root node and the others)
// you must have at least a root node to create a scene

// we implement the start method that we inherit from Application
// we inherit also the Launch static method
// it calls the start method behind the scenes

public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	// 	STEPS:
	// 	create the stage - we get already one as parameter
	//  create the root
	//	create the scene with the root as parameter
	// 	set the scene in the stage
	// 	show the stage
	@Override
	public void start(Stage stage) throws Exception {
		
		// if you want to create another stage:
		// Stage stage = new Stage();
		
		// there is many kind of root, Group is very basic
		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		
		stage.setTitle("Stage Demo Program");
		Image icon = new Image("MS-transp.png");
		stage.getIcons().add(icon);
		stage.setHeight(420);
		stage.setWidth(420);
		stage.setResizable(false);
		//stage.setX(50); // the position in the screen - top-left is 0,0
		//stage.setY(50);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("Premi z per uscire dalla modalità schermo intero.");
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("z"));
		
		stage.setScene(scene);
		stage.show();
		
		
	}
}
