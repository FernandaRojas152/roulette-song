package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import customExceptions.InsufficientPointsException;
import customExceptions.SongAlreadyExistsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Artist;
import model.Game;
import model.MusicLibrary;
import model.Song;
import model.Songwriter;
import util.SoundPlayer;

public class ChooseController{

	/** association with game controller to pass the added data to that controller*/
	private GameController gameController;

	/** Association with sign controller to get the actual user in the game*/
	private SignController sign;

	/**association with music library which it's the one who controls the linked list */
	private MusicLibrary music;

	/** Association with Game class*/
	private Game game;

	/** association with the song that's going to be playing*/
	private Song song;
	
	/**Association with the song writer */
	private Songwriter writer;

	/**Gets the path for the persistence songs data*/ 
	public static final String PATH = "resources/data/songData.txt";

	/**Gets the path for adding songs*/
	public static final String PATH_SONGS ="res/songs";

	/** association with the song that's going to be playing*/
	public String last= "";

	/** association with the song that's going to be playing*/
	private FXMLLoader loader;

	//private GameController GameController= loader.getController();
	private ListView list;
	
	@FXML
    private RadioButton taylor;

    @FXML
    private RadioButton bob;

    @FXML
    private RadioButton paul;

    @FXML
    private RadioButton lennon;
	@FXML
    private Button getMorePoints;
	
	@FXML
	private Button add;

	@FXML
	private TextField text;

	/**
	 * Constructor's method
	 */
	public ChooseController() {
		game= new Game();
		music= new MusicLibrary();
		song=null;
		list= new ListView<>();
		sign= new SignController();
	}

	public void initialize() {
		add.setDisable(true);
		try{
			if(game.getUser().getPoints() > 100) {
			add.setDisable(false);
			}else {
				throw new InsufficientPointsException();
			}
		}catch(NullPointerException e) {
			Platform.runLater(() -> {
				Alert dialog2 = new Alert(AlertType.ERROR, "You have to sign in first", ButtonType.OK);
				dialog2.show();
			});
		}catch(InsufficientPointsException e2) {
			Platform.runLater(() -> {
				Alert dialog2 = new Alert(AlertType.ERROR, e2.getMessage(), ButtonType.OK);
				dialog2.show();
			});
		}
	}


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
		sign.getActualUser();
		FileChooser file= new FileChooser();
		file.setTitle("Open Song File");
		//file.getExtensionFilters().addAll(new ExtensionFilter("Audio Files", ".wav", ".mp3"));
		List<File> selectedfile = file.showOpenMultipleDialog(null);
		if(selectedfile!=null) {
			for(int i=0; i< selectedfile.size(); i++) {
				//list.getItems().add(selectedfile.get(i).getAbsolutePath());
				if(music.search(selectedfile.get(i).getName(),selectedfile.get(i).getPath())) {
					throw new SongAlreadyExistsException();
				}
				System.out.println(System.getProperty("user.dir")+"\\"+selectedfile.get(i).getName());
				System.out.println("\\");
				try {
					transferFile(new FileInputStream(selectedfile.get(i).getPath()), new FileOutputStream(new File(System.getProperty("user.dir")+"\\"+"res\\songs\\"+selectedfile.get(i).getName())));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}			

				String name = selectedfile.get(i).getName();
				String path = System.getProperty("user.dir")+"\\"+selectedfile.get(i).getName();
				System.out.println(path);

				music.addSong(name, "/songs/"+name);
				System.out.println(music.getLast());
				//SoundPlayer.addSound(name, "/songs/"+name); 
				game.getUser().setPoints(game.getUser().getPoints()-100);

				gameController.updateMusic(music);
				System.out.println(selectedfile.get(i).getName());				
				System.out.println(path);
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
	 * @param d -path of the file
	 * @throws SongAlreadyExistsException -the song already exists
	 */
	public void loadSongs(String d) throws SongAlreadyExistsException {
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
		} catch (FileNotFoundException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}


	/**
	 * Makes the information persistent
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
		} catch (Exception e) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
				dialog.show();
			});
		}

	}

	/**
	 * This method saves the songs
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

	public void transferFile(InputStream source, OutputStream target) {

		try {
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = source.read(buffer)) != -1)
			{
				target.write(buffer, 0, bytesRead);
				target.flush();
			}

			source.close();
			target.close();

		}catch(Exception ex) {
			ex.printStackTrace();
		}


	}

	public void setGameController(GameController gameController) {

		this.gameController = gameController;
	}
	
	@FXML
    void morePoints(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Question.fxml"));
		Scene scene= new Scene(fxmlLoader.load());
		//scene.getStylesheets().add(getClass().getResource("/data/fontstyle.css").toExternalForm());
		Stage stage= new Stage();
		stage.setTitle("Get more points!");
		stage.setScene(scene);
		stage.show();
    }
	
	@FXML
    void answer(ActionEvent event) {
		sign.getActualUser();
    	if(taylor.isSelected()) {
    		writer= new Songwriter("Taylor Swift", "country", 3, "Songwriter");
    		game.addSongWriter(writer);
    		game.getUser().accumulatePoints(10);
    	}else if(bob.isSelected()) {
    		writer= new Songwriter("Bob Marley", "pop", 4, "lyricist");
    		game.addSongWriter(writer);
    		game.getUser().accumulatePoints(10);
    	}else if(paul.isSelected()) {
    		writer= new Songwriter("Paul mcCartney", "indie", 6, "lyricist");
    		game.addSongWriter(writer);
    		game.getUser().accumulatePoints(10);
    	}else if(lennon.isSelected()) {
    		writer= new Songwriter("John Lennon", "pop", 5, "Songwriter");
    		game.addSongWriter(writer);
    		game.getUser().accumulatePoints(10);
    	}else {
    		System.out.println("You didn't choose!");
    	}
    }

}