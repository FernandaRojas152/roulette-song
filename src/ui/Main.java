package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Fernanda
 * @version March 24th 2020
 * Class Main
 */

public class Main extends Application{
	private PrincipalWindowController principal;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("PrincipalWindow.fxml"));
		Scene scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/resources/fontstyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Roulette song");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}

}
