package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_SceneB {
	
	@FXML
	Label nameLabel;
	
	public void displayName (String username) {
		nameLabel.setText("Hello: " + username);
	}

}
