package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Controller_DatePicker {
	
	@FXML
	private Label myLabel;
	@FXML
	DatePicker myDatePicker;

	public void printDate(ActionEvent event) {
		
		LocalDate myDate = myDatePicker.getValue();
		String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
		myLabel.setText(myFormattedDate);
		
		
		
	}
	
	

}
