package ui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Game;
import model.User;

public class UserController {
	private ArrayList<User> user;
	private Game game;
	
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
		user= new ArrayList<>();
	}
    
	public void searchUser() {
		
	}
	
    public void showUserInformation() {
    	for(User users: user) {
    		
    	}
    	
    }

}
