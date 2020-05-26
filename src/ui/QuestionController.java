package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import model.Artist;
import model.Game;

public class QuestionController {
	/**Association with the artist */
	private Artist artist;
	/** Association with sign controller to get the actual user in the game*/
	private SignController sign;
	
	/** Association with Game class*/
	private Game game;
	
	public QuestionController() {
		game= new Game();
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
    void submit(ActionEvent event) throws FileNotFoundException, IOException {
    	sign.getActualUser();
    	if(taylor.isSelected()) {
    		artist= new Artist("Taylor Swift", "England", "Global Music");
    		game.addArtist(artist);
    		game.getUser().accumulatePoints(15);
    	}else if(ed.isSelected()) {
    		artist= new Artist("Ed Sheeran", "England", "American records");
    		game.addArtist(artist);
    		game.getUser().accumulatePoints(15);
    	}else if(onedirection.isSelected()) {
    		artist= new Artist("One Direction", "England", "SYNCO records");
    		game.addArtist(artist);
    		game.getUser().accumulatePoints(15);
    	}else {
    		System.out.println("You didn't choose!");
    	}
    	game.saveArtist();
    }

}
