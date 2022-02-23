package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



public class Controller_Mp3Player implements Initializable {
	
	@FXML
	private Pane pane;
	@FXML
	private Label songLabel;
	@FXML
	private Button playButton, pauseButton, resetButton, previousButton, nextButton;
	@FXML
	private ComboBox<String> speedBox;	
	@FXML
	private Slider volumeSlider;	
	@FXML
	private ProgressBar songProgressBar;
	
	private Media media;
	private MediaPlayer mediaPlayer;
	
	private File directory;
	private File[] files;
	private ArrayList<File> songs;
	private int songNumber;
	private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
	
	private Timer timer;
	private TimerTask task;
	private boolean running;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		songs = new ArrayList<File>();
		// we get all the files from the directory
		// and we fill an arraylist -songs- with all the files
		
		directory = new File("C:\\Users\\mario\\Javamapp\\12 Mario\\JavaFx\\HelloSceneBuilder\\src\\music");
	
		files = directory.listFiles();
		
		if (files != null) {
			for(File file : files) {
				songs.add(file);
			}
		}
		
		//creating media and MediaPlayer objects
		media = new Media(songs.get(songNumber).toURI().toString());
		mediaPlayer = new MediaPlayer(media); 
		
		//we set the name of the song in the songLabel
		songLabel.setText(songs.get(songNumber).getName());
		
		
	}
	
	public void playMedia() {
		mediaPlayer.play();
	}
	
	public void pauseMedia() {
		mediaPlayer.pause();
		
	}
	
	public void resetMedia() {
		mediaPlayer.seek(Duration.seconds(0.0));
	}

	public void previousMedia () {
		// if not first song
		if (songNumber > 0) {
			songNumber--;
			
			mediaPlayer.stop();
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			playMedia();
			
			songLabel.setText(songs.get(songNumber).getName());	
		} else {
			//if first song song let's start from the last one
			songNumber = songs.size() - 1;
			
			mediaPlayer.stop();
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songLabel.setText(songs.get(songNumber).getName());		
			
			playMedia();
		}
		
	}

	public void nextMedia () {
		// if not last song
		if (songNumber < songs.size() - 1) {
			songNumber++;
			
			mediaPlayer.stop();
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			playMedia();
			
			songLabel.setText(songs.get(songNumber).getName());	
		} else {
			//if last song let's start from 0
			songNumber = 0;
			
			mediaPlayer.stop();
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songLabel.setText(songs.get(songNumber).getName());		
			
			playMedia();
		}
	}
	
	public void changeSpeed (ActionEvent event) {
		
	}
	
	public void beginTimer () {
		
	}
	
	public void cancelTimer () {
		
	}
}
