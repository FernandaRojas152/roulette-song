package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Game;
import model.User;

public class SignController {
	private Game game;
	private User users;

    @FXML
    private TextField txtNickname;

    @FXML
    private PasswordField txtPassword;
    
    public SignController() {
    	game= new Game();
	}
    
    @FXML
    void signIn(ActionEvent event) {
    	try {
			users= game.searchUser(txtNickname.getText());
			String pass= String.valueOf(txtPassword.getText());
			
			if(users.getPassword().equalsIgnoreCase(pass) && users.getNickname().equalsIgnoreCase(txtNickname.getText())) {
				game.setUser(users);
			}
			
			System.out.println("bien");
		} catch (Exception e) {
			System.out.println("error");
			e.getMessage();
		}
    	}

}
