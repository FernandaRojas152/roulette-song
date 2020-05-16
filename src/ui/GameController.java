package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Image;
import model.MusicLibrary;
import thread.ImageThread;

/**
 * @version May 16th 2020
 * @author Fernanda
 * Class GameController
 */
public class GameController {
	/**association with music library which it's the one who controls the linked list */
	private MusicLibrary music;
	
	/** association with the image that's going to be rotating*/
	private Image i;
	
	private int x= 0;
	//attributes
	@FXML
	private ImageView roulette;
	
	
	public GameController() {
		i= new Image();
		roulette= new ImageView();
		music= new MusicLibrary();
		updateImage();
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
	
	/**
	 * This method will update the image so it keeps rotating
	 */
	public void updateImage() {
		roulette.setRotate(roulette.getRotate()+i.ANGLE);
	}
	
	@FXML
    void stop(ActionEvent event) {
		i.setSpin(false);
    }
	
	public void openList() {
		try {
            BufferedReader tec = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\config"));
            String aux = tec.readLine();
            if (aux.equals("Si")) {
                aux = tec.readLine();
                if (!aux.equals("vacio")) {
                    //cargarLista(aux);
                }
            } else {
                //cargarListaInicio.setSelected(false);
            }
        } catch (Exception e) {
        }
	}
	
	 /**public void cargarLista(String ruta) {
	        try {
	            FileInputStream fis = new FileInputStream(new File(ruta));
	            BufferedReader tec = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
	            String input[];
	            tec.readLine();

	            while (tec.ready()) {
	                input = tec.readLine().split("<");
	                System.out.println(input[0] + " , " + input[1]);
	                list.insertar(input[0], input[1]);
	                lista_modelo.addElement(input[0]);
	            }
	            ultimaLista = ruta;
	            cambios = false;
	        } catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\nal cargar la lista!!!", "alerta", 1);
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, "Ha ocurrido un error!!!", "alerta", 1);
	        }
	        lista_can.setModel(lista_modelo);
	    }
	    */
	
	@FXML
    void answer(ActionEvent event) {

    }
}
