package ui;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ChooseController {

	@FXML
	private ListView list;

	@FXML
	private Button add;

	/**
	 * This will add the song that the user chooses
	 * @param event
	 * @throws FileNotFoundException
	 */
	@FXML
	void addSong(ActionEvent event)throws FileNotFoundException{ 
		FileChooser file= new FileChooser();
		file.setTitle("Open Resource File");
		file.getExtensionFilters().addAll(
				new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
		File selectedfile = file.showOpenDialog(null);
		if(selectedfile!=null) {
			list.getItems().add(selectedfile.getName());
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

}
