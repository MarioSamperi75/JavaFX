package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
 
//Scene builder: connect On Content Menu Requested & on Mouse Clicked with the method selectItem

public class Controller_TreeView implements Initializable {
	@FXML
	private TreeView<String> myTreeView;
	
	@FXML
	private Label myLabel;
	Image myImage = new Image(getClass().getResourceAsStream("/images/folder.png"));
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		TreeItem<String> rootItem = new TreeItem<>("Files", new ImageView(myImage));
		
		TreeItem<String> brancheItem1 = new TreeItem<>("Pictures");
		TreeItem<String> brancheItem2 = new TreeItem<>("Videos");
		TreeItem<String> brancheItem3 = new TreeItem<>("Music");
		
		TreeItem<String> leafItem1 = new TreeItem<>("Picture1");
		TreeItem<String> leafItem2 = new TreeItem<>("Picture2");
		TreeItem<String> leafItem3 = new TreeItem<>("Video1");
		TreeItem<String> leafItem4 = new TreeItem<>("Video2");
		TreeItem<String> leafItem5 = new TreeItem<>("Music1");
		TreeItem<String> leafItem6 = new TreeItem<>("Music2");
		
		brancheItem1.getChildren().addAll(leafItem1, leafItem2);
		brancheItem2.getChildren().addAll(leafItem3, leafItem4);
		brancheItem3.getChildren().addAll(leafItem5, leafItem6);
		
		rootItem.getChildren().addAll(brancheItem1, brancheItem2, brancheItem3);
		
		
		//you can hide the root folder
		//myTreeView.setShowRoot(false);
		myTreeView.setRoot(rootItem);

		
	}
	
	public void selectItem() {
		
		TreeItem<String> item = myTreeView.getSelectionModel().getSelectedItem();
		if(item != null) {
		myLabel.setText(item.getValue());
		}
		
	}

	



	

}
