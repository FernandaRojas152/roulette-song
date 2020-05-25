package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import customExceptions.RequiredFieldsException;
import customExceptions.UserAlreadyExistsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;
import model.User;

/**
 * @version May 15h 2020 
 * @author Fernanda
 * Class RegisterController
 */
public class RegisterController {
	//associations
	private Game game;
	private User user;
	private Stage stage1;

	//Attributes
	/** A Text Field that it's going to get the name*/
	@FXML
	private TextField txtName;

	/**A Text Field that it's going to get the nickname */
	@FXML
	private TextField txtNickname;

	/**A Text Field that it's gonna get the gender */
	@FXML
	private TextField txtGender;

	/**A Text Field that it's gonna get the password */
	@FXML
	private PasswordField txtPassword;

	@FXML
	private Button register;

	//Methods
	/** 
	 * Constructor's method
	 * initialize game
	 */
	public RegisterController() {
		game= new Game();
		txtName= new TextField();
		txtNickname= new TextField();
		txtGender= new TextField();
		txtPassword= new PasswordField();
	}

	/**
	 * This method will register the user and catch all the exceptions that can happen meanwhile the user
	 * is trying to create a new account.
	 * <b> pre: user != null</b>
	 * <b> pos: new user created and save in a txt field <b>
	 */
	@FXML
	void registerUser(ActionEvent event) {
		try {
			user= new User(txtName.getText(), txtNickname.getText(), txtGender.getText(), txtPassword.getText());
			System.out.println(txtName.getText());
			System.out.println(txtNickname.getText());
			System.out.println(txtGender.getText());
			System.out.println(txtPassword.getText());
			
			addUser(user);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("User created!");
			alert.setHeaderText(null);
			alert.setContentText("Your user has been created succesfully!");
			alert.showAndWait();
			stage1 = (Stage) register.getScene().getWindow();
			stage1.close();
		}catch(RequiredFieldsException e2) {
			System.out.println("A wild exception appeared! What are you gonna do?");
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, e2.getMessage(), ButtonType.OK);
				dialog.show();
			});
		}catch(UserAlreadyExistsException e) {
			System.out.println("What are u gonna do? 1.Fix it with the given information 2.Try it again the same way(NOOOOOO)");
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
				dialog.show();
			});
		}
		try {
			game.save();
		}catch (FileNotFoundException e2) {
			e2.getMessage();
		}catch(IOException e) {
			e.getMessage();
		}
	}

	/**
	 * This method it's going to call the method from class game, so it's actually the one adding a user
	 * @param user -the object of type user that's going to be created
	 * @throws UserAlreadyExistsException -throws when the input nickname it's the same of an previously
	 * account registered. 
	 * @throws RequiredFieldsException -it's throwed when the user does not fill all the fields showed on screen.
	 */
	public void addUser(User user) throws UserAlreadyExistsException, RequiredFieldsException {
		game.addUser(user);
	}

}
