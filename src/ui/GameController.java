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
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import util.SoundPlayer;
import customExceptions.SongAlreadyExistsException;

/**
 * @version May 16th 2020
 * @author Fernanda
 * Class GameController
 */
public class GameController {
	/**association with music library which it's the one who controls the linked list */
	private MusicLibrary music;
	private Song song;

	/** association with the image that's going to be rotating*/
	private Image i;

	//attributes
	private boolean change= false;
	private boolean stop= false;
	public static final String PATH = "resources/data/songData.txt";
	public static final String PATH_SONGS ="res/songs";
	public String last= "";
	private int x= 0;

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

	@FXML
	private RadioButton byArtist;

	//methods
	/**
	 * Constructor's method
	 */
	public GameController() {
		i= new Image();
		roulette= new ImageView();
		music= new MusicLibrary();
		song=null;
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
		Scene scene= new Scene(fxmlLoader.load());
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

	/**
	 * When the user knows the answer, he can clic on this button and answer the name of the song
	 * @param event
	 */
	@FXML
	void answer(ActionEvent event) {

	}

	//associations



	//Methods

	/**
	 * This will add the song that the user chooses to a listview and the doubly linked list.
	 * @param event
	 * @throws FileNotFoundException- It's thrown when a user tries to add an audio file but it's not found or
	 * it's empty.
	 * @throws SongAlreadyExistsException -It's thrown when the user tries to add a song with the same name and the same
	 * file path.
	 */
	@FXML
	void addSong(ActionEvent event)throws FileNotFoundException, SongAlreadyExistsException{ 
		FileChooser file= new FileChooser();
		file.setTitle("Open Song File");
		file.getExtensionFilters().addAll(new ExtensionFilter("Audio Files", ".wav", ".mp3", "*.aac"));
		List<File> selectedfile = file.showOpenMultipleDialog(null);
		if(selectedfile!=null) {
			for(int i=0; i< selectedfile.size(); i++) {
				list.getItems().add(selectedfile.get(i).getName());
				if(music.search(selectedfile.get(i).getName(),selectedfile.get(i).getPath())) {
					throw new SongAlreadyExistsException();
				}
				System.out.println(System.getProperty("user.dir")+"\\"+selectedfile.get(i).getName());
				System.out.println("\\");
				try {
					transferFile(new FileInputStream(selectedfile.get(i).getPath()), new FileOutputStream(new File(System.getProperty("user.dir")+"\\"+"res\\songs\\"+selectedfile.get(i).getName())));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				music.addSong(selectedfile.get(i).getName(), selectedfile.get(i).getPath());
				System.out.println(music.getFirst().getFileP());
				System.out.println(selectedfile.get(i).getName());
				System.out.println(selectedfile.get(i).getPath());
			}
		}else {
			try {
				throw new FileNotFoundException("File not found.");
			} catch (Exception e) {
				Platform.runLater(() -> {
					Alert dialog = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
					dialog.show();
				});
			}
		}
	}


	/**
	 * This method will load a list that has been saved with song name and path.
	 *<b> pre: </b> 
	 * @param d
	 */
	public void loadSongs(String d) {
		try {
			FileInputStream fis = new FileInputStream(new File(d));
			BufferedReader bf = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			String input[];
			bf.readLine();

			while (bf.ready()) {
				input = bf.readLine().split(";");
				System.out.println(input[0] + "     " + input[1]);
				music.addSong(input[0], input[1]);
				list.getItems().add(input[0]);
			}
			last = d;
			change = false;
		} catch (FileNotFoundException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	@FXML
	void loadFile(ActionEvent event) {
		FileChooser file= new FileChooser();
		file.setTitle("Open Song List File");
		file.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt", "*.doc", "*.docx"));
		List<File> selectedfile = file.showOpenMultipleDialog(null);
		if (selectedfile!=null) {
			list.getItems().clear();
			for(int i=0; i< selectedfile.size(); i++) {
				song= music.first;
				loadSongs(selectedfile.get(i).getPath());
			}
		}
	}

	/**
	 * 
	 * @param d
	 */
	public void saveData(String d) {
		try {
			BufferedWriter bW = new BufferedWriter(new FileWriter(d));
			bW.write("\r\n");

			Song aux = music.first;
			while (aux != null) {
				bW.append(aux.getSongName() + ";" + aux.getFileP() + "\r\n");
				aux = aux.getNext();
			}

			bW.close();
			change= false;
		} catch (Exception e) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
				dialog.show();
			});
		}

	}



	/**
	 * 
	 * @param event
	 * @throws NullPointerException
	 */
	@FXML
	void saveSongs(ActionEvent event) throws NullPointerException{
		if(music.isEmpty()) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, "List is Empty!", ButtonType.OK);
				dialog.show();
			});
			return;
		}
		System.out.println("bien");
		saveData(PATH);
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
			if(song== null) {
				song= music.first;
			}
			try {
				if(x==0) {
					SoundPlayer.addSound("Test", song.getFileP());
					SoundPlayer.startSound("Test");
					System.out.println("inicia");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}


	public void transferFile(InputStream source, OutputStream target) {

		try {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = source.read(buffer, 0, buffer.length)) > 0)
			{
				target.write(buffer, 0, bytesRead);
				target.flush();
			}

			source.close();

		}catch(Exception ex) {
			ex.printStackTrace();

		}


	}
	public void playSong() {
	}
}
