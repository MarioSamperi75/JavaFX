package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;


public class Controller_Spinner implements Initializable {
	
	@FXML
	private Label myLabel;
	@FXML
	private Spinner<Integer> mySpinner;
	
	int currentValue;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// arguments: start and end values
		SpinnerValueFactory<Integer> valueFactory = 
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		
		valueFactory.setValue(1);
		
		mySpinner.setValueFactory(valueFactory);
		
		// to set an initial value
		currentValue = mySpinner.getValue();
		myLabel.setText(Integer.toString(currentValue));
		
		// to change the value by the spinner
		// how? in the same way but by implement the changed method!
		mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				currentValue = mySpinner.getValue();
				myLabel.setText(Integer.toString(currentValue));
				
			}
		});

		
	}

	
	

}
