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
	private ArrayList<User> users;
	private User user;
	private Game game;

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
	}

	public void initialize() {
	}

	
	/**
	 *This method shows the info of the user (nickname, gender, points)
	 * @throws UserDoesntExistException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	@FXML
	public void showUserInformation(ActionEvent event) throws UserDoesntExistException, FileNotFoundException, ClassNotFoundException, IOException {
		game.readData();
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Choose user");
		dialog.setHeaderText("You can see the ");
		dialog.setContentText("Please enter your name:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			User u= null;
			try {
				u= game.searchUser(result.get());
				nickname.setText(u.getNickname());
				gender.setText(u.getGender());
				points.setText(String.valueOf(u.getPoints()));
				nickname.setVisible(true);
				gender.setVisible(true);
				points.setVisible(true);
			}catch(UserDoesntExistException e) {
				e.getMessage();
			}
		}
	}
}
