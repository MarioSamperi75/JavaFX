package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;	
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



public class Controller_WebView implements Initializable {
	
	@FXML
	private WebView myWebView;

	@FXML
	private TextField myTextField;
	
	private WebEngine engine;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		engine = myWebView.getEngine();

	}

	public void loadPage () {
		engine.load("http://" + myTextField.getText());
	}


}
