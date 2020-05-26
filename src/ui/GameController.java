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
import java.util.Optional;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import model.Game;
import model.Image;
import model.MusicLibrary;
import model.Song;
import model.User;
import thread.ImageThread;
import thread.SongObserver;
import util.SoundPlayer;
import customExceptions.SongAlreadyExistsException;
import customExceptions.UserDoesntExistException;

/**
 * @version May 16th 2020
 * @author Fernanda
 * Class GameController
 */
public class GameController {
	/** association with the image that's going to be rotating*/
	private Image i;

	private boolean activarObserver = false;
	
	private SignController sign;
	private Game game;

	/** association with thread*/
	private SongObserver songO;

	/** association with the song that's going to be playing*/
	private Song song;

	/** Generates random numbers*/
	private Random r;

	/** association with the music that's going to be playing*/
	private MusicLibrary music;

	/** A Text Field that it's going to get the list*/
	@FXML
	private ListView list;

	@FXML
	private Button add;

	@FXML
	private Button stopButton;

	/** A Text Field that it's going to get the text*/
	@FXML
	private TextField text;

	/** A Text Field that it's going to get the roulette*/
	@FXML
	private ImageView roulette;

	@FXML
	private RadioButton random;

	@FXML
	private ToggleGroup options;

	@FXML
	private RadioButton sort;
	
	@FXML
    private ImageView gif;

	//methods
	/**
	 * Constructor's method 
	 */
	public GameController()  {
		game= new Game();
		i= new Image();
		roulette= new ImageView();
		music = new MusicLibrary();
		r= new Random();
		sign= new SignController();

		updateImage();
		try {
			addSongs();
		} catch (SongAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		songO= new SongObserver(music);


	}

	public void init() {
		stopButton.setOnAction(buttonHandler);
		sign.getActualUser();
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

	public void addSongs() throws SongAlreadyExistsException {
		music.addSong("Comethru", "/songs/Comethru.wav");
		music.addSong("Disarm You", "/songs/Disarm You.wav");
		music.addSong("Stacy", "/songs/Stacy.wav");
		music.addSong("Tired", "/songs/Tired.wav");

		SoundPlayer.addSound("Comethru", "/songs/Comethru.wav");
		SoundPlayer.addSound("Disarm You", "/songs/Disarm You.wav");
		SoundPlayer.addSound("Stacy", "/songs/Stacy.wav");
		SoundPlayer.addSound("Tired", "/songs/Tired.wav");
	}

	/**
	 * This method updates the song and play the next song in the list
	 * @param music -next music
	 */
	public void updateMusic(MusicLibrary music) { 
		this.music = music;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setActualUser(User user) {
		game.setUser(user);
	}

	/**
	 * When the user knows the answer, he can click on this button and answer the name of the song
	 * @param event
	 */
	@FXML
	void answer(ActionEvent event) {
		gif.setVisible(false);
		//System.out.println(sign.getActualUser());
		if(SoundPlayer.actualSong != null && !SoundPlayer.actualSong.equals("")) {
			SoundPlayer.stopActualSong();
			System.out.println(SoundPlayer.actualSong);
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Answer the name of song");
			dialog.setHeaderText("If your answer it's correct, you will obtain 10 points!");
			dialog.setContentText("Please enter just the NAME of the song:");

			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				try {
					if(result.get().equals(SoundPlayer.actualSong)) {
						System.out.println("Correcto");
						game.getUser().accumulatePoints(10);
						System.out.println(game.getUser().getPoints());
					}
				}catch(Exception e) {
					e.getMessage();
				}
			}
			//SoundPlayer.startSound(song.getNext().getFileP());
		}
	}

	/**
	 * This method stops the rotation of the image and then plays the song,sorted or randomly 
	 * @param event 
	 */
	@FXML 
	void stop(ActionEvent event) {
		System.out.println(game.getUser());
		i.setSpin(false);
		gif.setVisible(true);
		if(music.isEmpty()) {
			System.out.println("No hay canciones");
		}else {
			if(sort.isSelected()) {
				SoundPlayer.startSound(music.getFirst().getSongName());
			}else if(random.isSelected()) {
				
				Random ran = new Random();
				
				int index = (int) (ran.nextInt(music.getSize()));
				SoundPlayer.startSound(music.getSong(index).getSongName());
			}
			
			if(!activarObserver) {

				songO.start();
				activarObserver = true;
			}

		}
	}
}
