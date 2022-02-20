package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Controller_MenuBar {
	
	@FXML
	private Label myLabel;

	public void newMethod (ActionEvent event) {

		myLabel.setText("New Method! Nice, isn't it?");
	}
	
	public void notImplementedMethod (ActionEvent event) {

		myLabel.setText("Not yet implemented. Sorry.");
	}
	
	

}
