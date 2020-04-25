package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author Fernanda
 * @version March 24th 2020
 * Class Main
 */

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/**Label txtPoints = new Label("Points");
		txtPoints.setFont(new Font("Bebas Neue", 40));
		*/
		Parent root=FXMLLoader.load(getClass().getResource("PrincipalWindow.fxml"));
		Scene scene= new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("User profile");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
