package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.Clip;

import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import model.Image;
import model.MusicLibrary;
import model.Song;
import thread.ImageThread;
import thread.SongObserver;
import util.SoundPlayer;
import customExceptions.SongAlreadyExistsException;

/**
 * @version May 16th 2020
 * @author Fernanda
 * Class GameController
 */
public class GameController {
	/** association with the image that's going to be rotating*/
	private Image i;
	
	private SongObserver songO;
	private Song song;

	/** */
	private Random r;

	//attributes

	private int x= 0;

	private MusicLibrary music;

	@FXML
	private ListView list;

	@FXML
	private Button add;

	@FXML
	private Button stopButton;

	@FXML
	private TextField text;

	@FXML
	private ImageView roulette;

	@FXML
	private RadioButton random;

	@FXML
	private ToggleGroup options;

	@FXML
	private RadioButton sort;

	//methods
	/**
	 * Constructor's method
	 */
	public GameController() {
		i= new Image();
		roulette= new ImageView();
		music = new MusicLibrary();
		r= new Random();
		songO= new SongObserver();
		songO.start();
		updateImage();
	}

	public void init() {
		stopButton.setOnAction(buttonHandler);
	}


	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			stop(event);
		}
	};

	/**
	 * Goes to the next window to add(buy) a new song
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void buySong(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chooseSong.fxml"));
		Parent p = fxmlLoader.load();
		ChooseController c = fxmlLoader.getController();
		c.setGameController(this);		
		Scene scene= new Scene(p);
		Stage stage= new Stage();
		stage.setTitle("Game mode");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * This method will spin the image that represents a roulette
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void spin(ActionEvent event) throws IOException {
		ImageThread it= new ImageThread(i, this);
		i.setSpin(true);
		it.start();
	}

	/**
	 * This method will update the image so it keeps rotating
	 */
	public void updateImage() {
		roulette.setRotate(roulette.getRotate()+i.ANGLE);
	}

	public void updateMusic(MusicLibrary music) {

		this.music = music;

	}

	/**
	 * When the user knows the answer, he can click on this button and answer the name of the song
	 * @param event
	 */
	@FXML
	void answer(ActionEvent event) {
		if(SoundPlayer.actualSong != null && !SoundPlayer.actualSong.equals("")) {
			SoundPlayer.stopActualSong();
			SoundPlayer.startSound(song.getNext().getFileP());
			songO.setNextSong(song.getNext());
		}
	}

	/**
	 * 
	 * @param event 
	 */
	@FXML
	void stop(ActionEvent event) {
		i.setSpin(false);

		if(music.isEmpty()) {
			System.out.println("No hay canciones");
		}else {
			if(sort.isSelected()) {
				for(int i=0; i< music.getSize(); i++) {
					SoundPlayer.addSound(music.getSong(i).getSongName(), music.getFirst().getFileP());
					SoundPlayer.startSound(music.getSong(i).getSongName());
				}
			}else if(random.isSelected()) {

			}
			System.out.println(music.getFirst().getSongName());
			System.out.println(music.getFirst().getFileP());
		}
	}

	public void playSong() {
	}
}
