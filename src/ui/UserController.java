package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.User;

public class UserController {
	private User user;
	
    @FXML
    private ImageView image;

    @FXML
    private Label nick;

    @FXML
    private Label g;

    @FXML
    private Label txtPoints;

    @FXML
    private Label points;

    @FXML
    private Label nickname;

    @FXML
    private Label gender;

	public UserController() {
	}
    
	
    public void showUserInformation() {
    	
    }

}
