package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Controller_RadioButton {
	
	@FXML
	private Label myLabel;
	@FXML
	private RadioButton rButton1, rButton2, rButton3;
	
	
	Image myImage1 = new Image(getClass().getResourceAsStream("/images/OFF.png"));
	Image myImage2 = new Image(getClass().getResourceAsStream("/images/ON.png"));
	
	public void getItalianStuff(ActionEvent event) {
		
		if (rButton1.isSelected()) {
			myLabel.setText(rButton1.getText());
		} 
		else if(rButton2.isSelected()){
			myLabel.setText((rButton2.getText()));
		} 
		else if(rButton3.isSelected()){
			myLabel.setText((rButton3.getText()));
		}
		
		
	}
	
	

}
