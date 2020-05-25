package ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Game;
import model.User;

/**
 * @version May 22th 2020
 * @author Fernanda Class SignController
 */
public class SignController {
	// associations
	private Game game;
	private User users;
	private Stage stage1;
	private GameController gameC;
	// Attributes
	/** A Text Field that it's going to get the nickname */
	@FXML
	private TextField txtNickname;

	/** A Text Field that it's going to get the password */
	@FXML
	private PasswordField txtPassword;

	@FXML
	private Button logIn;

	// Methods
	/**
	 * Constructor's method initialize game
	 */
	public SignController() {
		game = new Game();
	}

	/**
	 * This method will login the user and catch all the exceptions that can happen
	 * meanwhile the user is trying to login. <b> pre: user != null</b> <b> pos: the
	 * user log-in
	 */
	@FXML
	void signIn(ActionEvent event) {

		try {
			game.readData();
			users = game.searchUser(txtNickname.getText());
			String pass = String.valueOf(txtPassword.getText());
			if (users.getPassword().equalsIgnoreCase(pass)
					&& users.getNickname().equalsIgnoreCase(txtNickname.getText())) {
				game.setUser(users);
				System.out.println("Welcome:  " + users.getNickname());
				System.out.println(game.getUser());
				gameC.setActualUser(users);
				stage1 = (Stage) logIn.getScene().getWindow();
				stage1.close();
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
				dialog.show();
			});
		}
	}
}
