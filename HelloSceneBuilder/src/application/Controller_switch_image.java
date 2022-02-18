package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller_switch_image {

// ImageView is a Node used for paint 	in images loaded with Images
// Image = photograph
// ImageView = picture frame
	
	//	SceneBuilder: 	connect the view with the controller
	//					give a name (id) to the component
	//					connect the action to the controller methods 
	//					(try on action for the button  and on mouse entered)
	
	@FXML
	ImageView myImageView;
	Button myButton;
	
	Image myImage = new Image(getClass().getResourceAsStream("/images/lion.png"));
	
	public void displayImage() {
		myImageView.setImage(myImage);
	}
	
	

}
