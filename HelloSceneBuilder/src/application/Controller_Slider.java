package application;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

// Initializable - see description in Controller_ChoiceBox
// both initializable and changeListener<> must implement a method (initialize, changed)


public class Controller_Slider implements Initializable{
	
	@FXML
	private Label myLabel;
	@FXML
	private Slider mySlider;

	int myTemperature;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//to set the value at the beginning, before the event
		myTemperature = (int) mySlider.getValue();
		myLabel.setText(Integer.toString(myTemperature)+"C°");
		
		mySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				myTemperature = (int) mySlider.getValue();
				myLabel.setText(Integer.toString(myTemperature)+"C°");
			}
		});
	}

}
