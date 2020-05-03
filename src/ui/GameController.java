package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController {

    @FXML
    void gameModeConfig(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameModeConfiguration.fxml"));
    	Scene scene= new Scene(fxmlLoader.load());
    	Stage stage= new Stage();
    	stage.setTitle("Game mode");
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void songConfig(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SongsConfiguration.fxml"));
    	Scene scene= new Scene(fxmlLoader.load());
    	Stage stage= new Stage();
    	stage.setTitle("Configuration");
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void spin(ActionEvent event) throws IOException {
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
