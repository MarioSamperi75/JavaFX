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
import javafx.scene.shape.Circle;



public class Controller_KeyEvents {
	
	@FXML
	private Label myLabel;
	
	@FXML
	private Circle myCircle;
	
	private double x; 
	private double y;
	

	
	public void moveUp () {
		myLabel.setText("Movin' up!");
		myCircle.setCenterY(y-=10);
	}
	
	public void moveDown () {
		myLabel.setText("Movin' down!");
		myCircle.setCenterY(y+=10);
	}
	
	public void moveLeft () {
		myLabel.setText("Movin' left!");
		myCircle.setCenterX(x-=10);
	}
	
	public void moveRight () {
		myCircle.setCenterX(x+=10);
		myLabel.setText("Movin' right!");
	}
	
	
	
	
	
	
	
	
	

}
