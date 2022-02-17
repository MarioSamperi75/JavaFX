package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

// you can connect these events and elements by using Scene Builder
// Rigth clicks on Event.fxml --> open with scene builder
// in SceneBuilder: button-code-onAction (select the event)
// 					circle-code-fx-id:(select the name of the object 
//										- myCircle in this case)

public class Controller {
	
	// it will inject all the values from FXML file to your controller
	@FXML
	private Circle myCircle;
	private double x; 
	private double y;
	
	public void up(ActionEvent e) {
		//System.out.println("UP");
		myCircle.setCenterY(y-=10);
	}
	public void down(ActionEvent e) {
		//System.out.println("DOWN");
		myCircle.setCenterY(y+=10);
	}
	public void left(ActionEvent e) {
		//System.out.println("LEFT");
		myCircle.setCenterX(x-=10);
	}
	public void rigt(ActionEvent e) {
		//System.out.println("RIGHT");
		myCircle.setCenterX(x+=10);
	}

}
