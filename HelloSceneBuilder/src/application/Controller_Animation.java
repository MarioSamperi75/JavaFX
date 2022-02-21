package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Controller_Animation implements Initializable{

// ImageView is a Node used for paint 	in images loaded with Images
// Image = photograph
// ImageView = picture frame
	
	//	SceneBuilder: 	connect the view with the controller
	//					give a name (id) to the component
	//					connect the action to the controller methods 
	//					(try on action for the button  and on mouse entered)
	
	@FXML
	ImageView myImageView;
	@FXML
	Button scaleButton;
	@FXML
	Button fadeButton;
	@FXML
	Button rotateButton;
	
	int switcher = 0;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImageView);
		
	}
	
	public void translate(int x, int y) {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImageView);
		translate.setDuration(Duration.millis(500));
		//translate.setCycleCount(2); //TranslateTransition.INDEFINITE to repeat the transaction FOR EVER.
		translate.setByX(x);
		translate.setByY(y);
		//translate.setAutoReverse(true);
		translate.play();
	
	}
	
	public void translateRight() {
		translate(150, 0);
	}
	
	public void translateLeft() {
		translate(-150, 0);
	}
	
	public void translateUp() {
		translate(0, -150);
	}
	
	public void translateDown() {
		translate(0, 150);
	}
	
	public void rotate() {
		RotateTransition rotate = new RotateTransition();
		rotate.setNode(myImageView);
		rotate.setDuration(Duration.millis(1000));
		rotate.setCycleCount(TranslateTransition.INDEFINITE);
		//rotate.setAxis(Rotate.X_AXIS);  //Z_AXIS is the default
		
		if (switcher == 0) {
			rotate.setByAngle(-360);
			rotateButton.setTextFill(Color.RED);
			switcher = 1;
		} 
		else {
			rotate.stop();
			rotateButton.setTextFill(Color.BLACK);
			switcher = 0;
		}
		System.out.println(switcher);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.play();
	
	}
	
	public void fade() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(myImageView);
		fade.setDuration(Duration.millis(1000));
		fade.setCycleCount(1);
		fade.setInterpolator(Interpolator.LINEAR);
		
		
		if (switcher == 0) {
			fade.setFromValue(1);
			fade.setToValue(0);
			fadeButton.setTextFill(Color.RED);
			switcher = 1;
		} 
		else {
			fade.setFromValue(0);
			fade.setToValue(1);
			fadeButton.setTextFill(Color.BLACK);
			switcher = 0;
		}
		System.out.println(switcher);
		
		fade.play();
	
	}
	
	public void scale() {
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(myImageView);
		scale.setDuration(Duration.millis(1000));
		scale.setCycleCount(1);
		scale.setInterpolator(Interpolator.LINEAR);
		
		
		if (switcher == 0) {
			scale.setByX(2.0);
			scale.setByY(2.0);
			scaleButton.setTextFill(Color.RED);
			switcher = 1;
		} 
		else {
			scale.setByX(-2.0);
			scale.setByY(-2.0);
			scaleButton.setTextFill(Color.BLACK);
			switcher = 0;
		}
		
		scale.play();
	}
}
