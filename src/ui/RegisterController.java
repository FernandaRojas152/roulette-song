package ui;

import customExceptions.RequiredFieldsException;
import customExceptions.UserAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    		
    	}catch(RequiredFieldsException e2) {
    		e2.getMessage();
    	}catch(UserAlreadyExistsException e) {
    		e.getMessage();
    	}
    }
    
    public void addUser(User user) throws UserAlreadyExistsException, RequiredFieldsException {
    	game.addUser(user);
    }

}
