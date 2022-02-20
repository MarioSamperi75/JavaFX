package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller_ListView implements Initializable {
	
	@FXML
	private Label myLabel;
	@FXML
	ListView<String> myListView;
	
	String[] wine = {"Brunello", "Nobile", "Navajas", "Corvo", "Sassicaia"};
	String currentWine;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		myListView.getItems().addAll(wine);
		
		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				currentWine= myListView.getSelectionModel().getSelectedItem();
				myLabel.setText(currentWine);
				
			}
			
		});
		
		
	}


	
	

}
