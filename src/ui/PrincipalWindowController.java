package ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

public class PrincipalWindowController {
	private Game game;
	
	public PrincipalWindowController() {
		game= new Game();
	}
	
	public void initialize() {
	}

    @FXML
    void logIn(ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
    	Scene scene= new Scene(fxmlLoader.load());
    	//scene.getStylesheets().add(getClass().getResource("/resources/fontstyle.css").toExternalForm());
    	Stage stage= new Stage();
    	stage.setTitle("Log in");
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void play(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Playing.fxml"));
    	Scene scene= new Scene(fxmlLoader.load());
    	//scene.getStylesheets().add(getClass().getResource("/resources/fontstyle.css").toExternalForm());
    	Stage stage= new Stage();
    	stage.setTitle("Roulette Song");
    	stage.setScene(scene);
    	stage.show();
    	
    	/** it can hide the current window*/
    	//((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void signIn(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
    	Scene scene= new Scene(fxmlLoader.load());
    	//scene.getStylesheets().add(getClass().getResource("/resources/fontstyle.css").toExternalForm());
    	Stage stage= new Stage();
    	stage.setTitle("Sign in");
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
	void userProfile(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("User.fxml"));
		Scene scene= new Scene(fxmlLoader.load());
		Stage stage= new Stage();
		stage.setTitle("User profile");
		stage.setScene(scene);
		stage.show();
	}
}
