package ui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Game;
import model.User;

/**
 * @version May 22h 2020 
 * @author Fernanda
 * Class UserController
 */

public class UserController {
	//associations
	private ArrayList<User> user;
	private Game game;
	
	//Attributes
	/** A Text Field that it's going to get the image*/
    @FXML
    private ImageView image;

	/** A Text Field that it's going to get the nickname*/
    @FXML
    private Label nick;

	/** A Text Field that it's going to get the gender*/
    @FXML
    private Label g;

	/** A Text Field that it's going to get the txtPoints*/
    @FXML
    private Label txtPoints;

	/** A Text Field that it's going to get the points*/
    @FXML
    private Label points;

	/** A Text Field that it's going to get the nickname*/
    @FXML
    private Label nickname;
    
	/** A Text Field that it's going to get the gender*/
    @FXML
    private Label gender;

  //Methods
  	/** 
  	 * Constructor's method
  	 */
	public UserController() {
		user= new ArrayList<>();
	}
    
	/**
	 * This method search the user wanted and shows it
	 */
	public void searchUser() {
		
	}
		
	/**
	 *This method shows the info of the user (nickname, gender, points)
	 */
    public void showUserInformation() {
    	for(User users: user) {
    		
    	}
    	
    }

}
