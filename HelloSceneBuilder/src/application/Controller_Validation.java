package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller_Validation {

// ImageView is a Node used for paint 	in images loaded with Images
// Image = photograph
// ImageView = picture frame
	
	//	SceneBuilder: 	connect the view with the controller
	//					give a name (id) to the component
	//					connect the action to the controller methods 
	//					(try on action for the button  and on mouse entered)
	
	@FXML
	private Label myLabel;
	@FXML
	Button myButton;
	@FXML
	TextField myTextField;
	
	int age;

	
	public void submit() {
		
		try {
			age = Integer.parseInt(myTextField.getText());
			if (age>18) {
				myLabel.setText("You ar now signed up!");
			} else {
				myLabel.setText("You must be 18+");
			}
		
		} 
		catch (NumberFormatException e) {
			myLabel.setText("Enter only numbers please");
		}
		catch (Exception e) {
			myLabel.setText("Error");
		}
		
	}
	
	

}
