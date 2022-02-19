package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


// it's not possible to fill the choice box by using Scene Builder
// to do it you have to add implement Initializable
// add the unimplemented method initialize
// and in it you have to populate the choiceBox


public class Controller_ChoiceBox implements Initializable{
	
	@FXML
	private Label myLabel;
	@FXML
	ChoiceBox<String> myChoiceBox;

	private String[] food = {"Brunello", "Barolo", "Corvo"};	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoiceBox. getItems().addAll(food);
		// you have also to connect the choiceBox to the method
		myChoiceBox.setOnAction(this::getWine);
	}
	
	public void getWine (ActionEvent event) {
		
		String myWine = myChoiceBox.getValue();
		myLabel.setText(myWine);
	}
	
	

}
