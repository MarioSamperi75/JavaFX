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
	
	private String homePage; 
	
	double webZoom;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		engine = myWebView.getEngine();
		homePage = "www.google.com";
		webZoom = 1.0;
		myTextField.setText(homePage);
		loadPage();

	}

	public void loadPage () {
		engine.load("http://" + myTextField.getText());
	}
	
	public void refreshPage () {
		engine.reload();
	}
	
	public void zoomIn () {
		webZoom += 0.1;
		myWebView.setZoom(webZoom);
	}
	
	public void zoomOut () {
		webZoom -= 0.1;
		myWebView.setZoom(webZoom);
	}


}