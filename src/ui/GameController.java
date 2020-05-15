package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Image;
import thread.ImageThread;

public class GameController {
	private Image i;
	@FXML
	private ImageView roulette;
	
	
	public GameController() {
		i= new Image();
		roulette= new ImageView();
		
		updateImage();
		// TODO Auto-generated constructor stub
	}
	
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
		ImageThread it= new ImageThread(i, this);
		i.setSpin(true);		
		it.start();
	}
	
	public void updateImage() {
		roulette.setRotate(roulette.getRotate()+i.ANGLE);
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
