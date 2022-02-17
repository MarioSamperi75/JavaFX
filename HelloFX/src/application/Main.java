package application;





import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

// multi-layer structure: Stage - Scene - SceneGraph - nodes (root node and the others)
// you must have at least a root node to create a scene

// we implement the start method that we inherit from Application
// we inherit also the Launch static method
// it calls the start method behind the scenes

public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	// create a element
	// define its properties
	// add it to the root
	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, 600,600, Color.DARKBLUE);
		Stage stage = new Stage();
		
		Text text = new Text();
		text.setText("FORZA JUVE!!!");
		text.setX(50);
		text.setY(50);
		text.setFont(Font.font("Verdana", 50));
		text.setFill(Color.YELLOW);
		
		
		Line line = new Line();
		line.setStartX(200);
		line.setStartY(200);
		line.setEndX(500);
		line.setEndY(200);
		line.setStrokeWidth(8);
		line.setStroke(Color.RED);
		line.setOpacity(0.5);
		line.setRotate(45);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setX(100);
		rectangle.setY(100);
		rectangle.setWidth(100);
		rectangle.setHeight(100);
		rectangle.setFill(Color.GREEN);
		rectangle.setStrokeWidth(4);
		rectangle.setStroke(Color.BLACK);
		
		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(
				300.0,300.0,
				400.0,300.0,
				300.0,400.0
				);
		triangle.setFill(Color.BURLYWOOD);
		triangle.setStrokeWidth(4);
		triangle.setStroke(Color.BLACK);
		
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(300);
		circle.setRadius(50);
		circle.setFill(Color.ORANGE);
		circle.setStrokeWidth(3);
		circle.setStroke(Color.BLACK);
		
		Image image = new Image("zebra.png");
		ImageView imageView = new ImageView(image);
		imageView.setX(350);
		imageView.setY(400);
		
		
		
		
		

		root.getChildren().add(text);
		root.getChildren().add(line);
		root.getChildren().add(rectangle);
		root.getChildren().add(triangle);
		root.getChildren().add(circle);
		root.getChildren().add(imageView);
		
		stage.setScene(scene);
		stage.show();
		
		
	}
}
