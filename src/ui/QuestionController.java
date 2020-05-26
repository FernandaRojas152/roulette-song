package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import model.Artist;

public class QuestionController {
	/**Association with the artist */
	private Artist artist;
	
	public QuestionController() {
	}
	
	public void initialize() {
		
	}
    @FXML
    private RadioButton taylor;

    @FXML
    private RadioButton ed;

    @FXML
    private RadioButton onedirection;

    @FXML
    void submit(ActionEvent event) {
    	if(taylor.isSelected()) {
    		artist= new Artist("Taylor Swift", "England", "Global Music");
    	}else if(ed.isSelected()) {
    		artist= new Artist("Ed Sheeran", "England", "American records");
    	}else if(onedirection.isSelected()) {
    		artist= new Artist("One Direction", "England", "SYNCO records");
    	}else {
    		System.out.println("You didn't choose!");
    	}
    }

}
