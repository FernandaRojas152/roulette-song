package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import customExceptions.SongAlreadyExistsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.MusicLibrary;
import model.Song;
import javafx.stage.FileChooser.ExtensionFilter;

public class ChooseController {
	//associations
	private MusicLibrary music;
	private Song song=null;
	
	//attributes
	private boolean change= false;
	public static final String PATH = "resources/data/songData.txt";
	
	@FXML
	private ListView list;

	@FXML
	private Button add;

	@FXML
	private TextField text;
	
	//Methods
	/**
	 * Constructor's method
	 */
	public ChooseController() {
		music= new MusicLibrary();
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
		file.getExtensionFilters().addAll(new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
		List<File> selectedfile = file.showOpenMultipleDialog(null);
		if(selectedfile!=null) {
			for(int i=0; i< selectedfile.size(); i++) {
				list.getItems().add(selectedfile.get(i).getName());
				if(music.search(selectedfile.get(i).getName(),selectedfile.get(i).getPath())) {
					throw new SongAlreadyExistsException();
				}
				music.addSong(selectedfile.get(i).getName(), selectedfile.get(i).getPath());
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

	/**public String createList() {
        //String n = JOptionPane.showInputDialog("digite el nombre de la lista");
        String n= text.getText();
        if (n == null || n.isEmpty()) {
            return null;
        }
        FileChooser fileC= new FileChooser();
        int seleccion = fileC.showOpenDialog(this);
        File ruta;

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            ruta = chooser.getSelectedFile();
        } else {
            return null;
        }
        File save = new File(ruta.getAbsolutePath() + "\\" + n + ".lis");
        if (save.exists()) {
            save.delete();
        }
        return save.getAbsolutePath();
    }
	 */
	/**
	 * 
	 */
	public void openList() {
		try {
			BufferedReader tec = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\config"));
			String aux = tec.readLine();
			if (aux.equals("Si")) {
				aux = tec.readLine();
				if (!aux.equals("vacio")) {
					//cargarLista(aux);
				}
			} else {
				//cargarListaInicio.setSelected(false);
			}
		} catch (Exception e) {
		}
	}

	/**public void cargarLista(String ruta) {
	        try {
	            FileInputStream fis = new FileInputStream(new File(ruta));
	            BufferedReader tec = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
	            String input[];
	            tec.readLine();

	            while (tec.ready()) {
	                input = tec.readLine().split("<");
	                System.out.println(input[0] + " , " + input[1]);
	                list.insertar(input[0], input[1]);
	                lista_modelo.addElement(input[0]);
	            }
	            ultimaLista = ruta;
	            cambios = false;
	        } catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\nal cargar la lista!!!", "alerta", 1);
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, "Ha ocurrido un error!!!", "alerta", 1);
	        }
	        lista_can.setModel(lista_modelo);
	    }
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

	@FXML
	void loadFile(ActionEvent event) {

	}

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

}
