package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UserController {
	@FXML
	private Label txtPoints;

	@FXML
	private Label points;

	@FXML
	private Label nickname;

	@FXML
	private Label gender;

	@FXML
	private Text text;
	
	public Text getText() {
		return text;
	}

	/**
	public Label getTxtPoints() {
		Font font= new Font("Bebas Neue", 40);
		Label txtPoints = new Label("Points");
		txtPoints.setFont(new Font("Bebas Neue", 40));
		return txtPoints.setFont(new Font("Bebas Neue", 40));;
	}
	 */
}
