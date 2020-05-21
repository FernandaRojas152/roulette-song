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
import customExceptions.SongAlreadyExistsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.MusicLibrary;
import model.Song;
import util.SoundPlayer;

public class ChooseController {
	
	
	private GameController gameController;
	/**association with music library which it's the one who controls the linked list */
	private MusicLibrary music;
	/** */
	private Song song;
	/** */ 
	public static final String PATH = "resources/data/songData.txt";
	/** */
	public static final String PATH_SONGS ="res/songs";
	/** */
	public String last= "";
	/** */
	private boolean change;
	/** */
	private boolean stop;
	
	private FXMLLoader loader;
	
	//private GameController GameController= loader.getController();
	private ListView list;

	@FXML
	private Button add;
	
	@FXML
	private TextField text;
	
	/**
	 * Constructor's method
	 */
	public ChooseController() {
		music= new MusicLibrary();
		song=null;
		change= false;
		stop= false;
		list = new ListView<Song>();
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
		FileChooser file= new FileChooser();
		file.setTitle("Open Song File");
		//file.getExtensionFilters().addAll(new ExtensionFilter("Audio Files", ".wav", ".mp3"));
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
				} catch (IOException e2) {
					e2.printStackTrace();
				}			
				
				String name = selectedfile.get(i).getName();
				String path = System.getProperty("user.dir")+"\\"+selectedfile.get(i).getName();
				
				music.addSong(name, "/songs/"+name);
//				SoundPlayer.addSound(name, "/songs/"+name); 
				
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

}