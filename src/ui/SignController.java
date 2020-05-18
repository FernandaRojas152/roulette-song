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

public class SignController {
	private Game game;
	private User users;
	private Stage stage1;

	@FXML
	private TextField txtNickname;

	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Button sign;

	public SignController() {
		game= new Game();
	}
	/**
	 * 
	 * @param event
	 */
	@FXML
	void signIn(ActionEvent event) {
		try {
			game.readData();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		try {
			users= game.searchUser(txtNickname.getText());
			String pass= String.valueOf(txtPassword.getText());
			if(users.getPassword().equalsIgnoreCase(pass) && users.getNickname().equalsIgnoreCase(txtNickname.getText())) {
				game.setUser(users);
				System.out.println("Welcome:  "+ users.getNickname());
			}
		} catch (Exception e) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
				dialog.show();
			});
		}
	}
}
