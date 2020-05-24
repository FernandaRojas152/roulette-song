package ui;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Game;

/**
 * @version May 21th 2020
 * @author Fernanda
 * Class PrincipalWindowController
 */
public class PrincipalWindowController {
	/** */
	private Game game;
	/** */
	public static boolean isMoving;
	/** */
	public static final double STEP_RIGHT = 5;
	/** */
	public static final double STEP_LEFT = -5;
	/** */
	private double posX;

	@FXML
	private Label message;
	@FXML
	private AnchorPane pane;
	
	/**
	 * 
	 */
	public PrincipalWindowController() {
		game= new Game();
		message= new Label();
		isMoving= true;
		posX=5;
	}
	
	/**
	 * 
	 */
	public void initialize() {
		new Thread() {
			public void run() {
				while(isMoving) {
					Platform.runLater(new Thread() {
						public void run() {
							move();
						}
					});
					message.setLayoutX(message.getLayoutX() + posX);
					try {
						Thread.sleep(60);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@FXML
	void logIn(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
		Scene scene= new Scene(fxmlLoader.load());
		scene.getStylesheets().add(getClass().getResource("/data/fontstyle.css").toExternalForm());
		Stage stage= new Stage();
		stage.setTitle("Log in");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void play(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Playing.fxml"));
		Scene scene= new Scene(fxmlLoader.load());
		scene.getStylesheets().add(getClass().getResource("/data/fontstyle.css").toExternalForm());
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
		scene.getStylesheets().add(getClass().getResource("/data/fontstyle.css").toExternalForm());
		Stage stage= new Stage();
		stage.setTitle("Sign in");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void userProfile(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("User.fxml"));
		Scene scene= new Scene(fxmlLoader.load());
		scene.getStylesheets().add(getClass().getResource("/data/fontstyle.css").toExternalForm());
		Stage stage= new Stage();
		stage.setTitle("User profile");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * 
	 */
	public void move() {
		if(message.getLayoutX() +posX <=0) {
			posX= PrincipalWindowController.STEP_RIGHT;
		}else if(message.getLayoutX() + posX > pane.getWidth()) {

			posX= PrincipalWindowController.STEP_LEFT;
		}
	}
}
