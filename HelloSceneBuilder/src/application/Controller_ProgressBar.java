package application;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class Controller_ProgressBar implements Initializable{
	
	// the issue here is that working with double can be little inaccurate
	// we have to use BigDecimal and round
	// and stop the progress by using an if 
	
	@FXML
	private Label myLabel;
	@FXML
	private ProgressBar myProgressBar;
	@FXML
	private Button myButton;
	
	// the argument is the starting value
	// we need to use the double value because the property of the progress bar har an interval (0.0 / 1.0)
	// to access the double value we will use the method doubleValue()
	BigDecimal progress = new BigDecimal("0.0");

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		myProgressBar.setStyle("-fx-accent: #00FF00;");
	
		
	}
	
	public void increaseProgress() {
		if (progress.doubleValue() < 0.99) {
		// BigDecimals are immutable,to update them you have to reinstanciate 
		// remember that the argument is the starting value, in this case updated value
		progress = new BigDecimal(progress.doubleValue() + 0.1);
		myProgressBar.setProgress(progress.doubleValue());
		myLabel.setText(Integer.toString((int)Math.round(progress.doubleValue()*100)) + "%");
		}
	}
	
	

}
