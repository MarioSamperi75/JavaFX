package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private int[] speeds = {25, 50, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125, 150, 175, 200};
	
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
		
		//populate the speedBox with the array of speeds
		for (int i = 0; i < speeds.length; i++) {
			speedBox.getItems().add(Integer.toString(speeds[i]) + "%");
		}
		
		// we set the onAction method to the speedBox and  onAction, we calls the method changeSpeed
		speedBox.setOnAction(this::changeSpeed);
		
		// we add a listener with an anonymous function to set and change the volume
		volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			}
		});
		
		songProgressBar.setStyle("-fx-accent : #000000; -fx-border-color : #FFFF00");
		
		
		
	}
	
	public void playMedia() {
		// we must set the execution speed before playing anyway
		// even if we doesn't click in the  speedBox -maybe is already 200%...
		// so even if the event is null
		// the same for the volume
		
		// we start the timer!
		beginTimer();
		changeSpeed(null);
		mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
		mediaPlayer.play();
	}
	
	public void pauseMedia() {
		cancelTimer();
		mediaPlayer.pause();
		
	}
	
	public void resetMedia() {
		//when we reset, we have to reset the progressBar too
		songProgressBar.setProgress(0);
		mediaPlayer.seek(Duration.seconds(0.0));
	}

	public void previousMedia () {
		// if not first song
		if (songNumber > 0) {
			songNumber--;
			
			mediaPlayer.stop();
			
			// you can use previous and next with a running or no-running song   
			if (running) {
				cancelTimer();
			}
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			playMedia();
			
			songLabel.setText(songs.get(songNumber).getName());	
		} else {
			//if first song song let's start from the last one
			songNumber = songs.size() - 1;
			
			mediaPlayer.stop();
			
			// you can use previous and next with a running or no-running song   
			if (running) {
				cancelTimer();
			}
			
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
			
			// you can use previous and next with a running or no-running song   
			if (running) {
				cancelTimer();
			}
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			playMedia();
			
			songLabel.setText(songs.get(songNumber).getName());	
		} else {
			//if last song let's start from 0
			songNumber = 0;
			
			mediaPlayer.stop();
			
			// you can use previous and next with a running or no-running song   
			if (running) {
				cancelTimer();
			}
			
			//creating media and MediaPlayer objects
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songLabel.setText(songs.get(songNumber).getName());		
			
			playMedia();
		}
	}
	
	public void changeSpeed (ActionEvent event) {
		// taking from the box, parsing and setRate
		// we avoid to get the "%" by getting a substring
		
		// if we use next or previous without changing rate, 
		// we would send a null value into this set rate!! error!!
		// so we have to check if is null, in this case we set 1 as default
		
		if (speedBox.getValue() == null) {
			mediaPlayer.setRate(1);
		}
		else {
		mediaPlayer.setRate(Integer.parseInt(speedBox.getValue().substring(0, speedBox.getValue().length()-1)) * 0.01);
		}
	}
	
	public void beginTimer () {
		
		// we set the general Timer and the single timerTask
		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				running = true;
				double current = mediaPlayer.getCurrentTime().toSeconds();
				double end = media.getDuration().toSeconds();
				songProgressBar.setProgress(current/end);
				
				if (current/end == 1) {
					cancelTimer();
				}
			}
		};
		// a new task after 1000ms every 1000ms
		timer.scheduleAtFixedRate(task, 0, 1000);
		
	}
	
	public void cancelTimer () {
		
		running = false;
		timer.cancel();
	}
}
