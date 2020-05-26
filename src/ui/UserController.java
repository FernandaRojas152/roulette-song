package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import customExceptions.UserDoesntExistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
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
	/** */
	private ArrayList<User> users;
	/** */
	private User user;
	/** */
	private Game game;
	/** */
	private SignController sign;

	//Attributes
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
		users= new ArrayList<>();
		game= new Game();
		sign= new SignController();
	}

	public void initialize() {
	}


	/**
	 *This method shows the info of the actual user that logins in the game (nickname, gender and points)
	 * @throws UserDoesntExistException -user it's not in the game
	 * @throws IOException  -IOException 
	 * @throws ClassNotFoundException -Class not found
	 * @throws FileNotFoundException -File not found
	 * @param event -event in the game
	 */
	@FXML
	public void showUserInformation(ActionEvent event) throws UserDoesntExistException, FileNotFoundException, ClassNotFoundException, IOException {
		sign.getActualUser();
		nickname.setText(game.getUser().getNickname());
		gender.setText(game.getUser().getGender());
		points.setText(String.valueOf(game.getUser().getPoints()));
		nickname.setVisible(true);
		gender.setVisible(true);
		points.setVisible(true);
	}
}
