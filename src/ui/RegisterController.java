package ui;

import customExceptions.RequiredFieldsException;
import customExceptions.UserAlreadyExistsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Game;
import model.User;

public class RegisterController {
	private Game game;
	private User user;
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNickname;

    @FXML
    private TextField txtGender;

    @FXML
    private PasswordField txtPassword;
    
    public RegisterController() {
		game= new Game();
	}
    @FXML
    void registerUser(ActionEvent event) {
    	try {
    		user= new User(txtName.getText(), txtNickname.getText(), txtGender.getText(), txtPassword.getText());
    		addUser(user);
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("User created!");
    		alert.setHeaderText(null);
    		alert.setContentText("Your user has been created succesfully!");

    		alert.showAndWait();
    		
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
    }
    
    public void addUser(User user) throws UserAlreadyExistsException, RequiredFieldsException {
    	game.addUser(user);
    }

}
