package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller_Logout {
	
	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane scenePane;
	
	Stage stage;
	
	public void logout (ActionEvent event) {
		
		stage = (Stage) scenePane.getScene().getWindow();
		System.out.println("you successfully logged out!!!");
		stage.close();
		
	}

}
