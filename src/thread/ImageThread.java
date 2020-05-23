package thread;

import model.Image;
import ui.GameController;

/**
 * @version May 15th 2020
 * @author Fernanda
 * Class ImageThread
 */
public class ImageThread extends Thread{
	/**
	 * Association with the image
	 */
	private Image image;
	
	/**
	 * Association with the game controller class
	 */
	private GameController game;
	
	/**
	 * Constructor's method
	 * @param image -the image that's gonna be rotated
	 * @param game -the controller that updates the rotation
	 */
	public ImageThread(Image image, GameController game) {
		this.image = image;
		this.game = game;
	}
	
	/**
	 * This method gets the image
	 * @return image
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * This method modifies the image
	 * @param image -the new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * This method gets the actual game
	 * @return game
	 */
	public GameController getGame() {
		return game;
	}
	
	/**
	 * This method modifies the game
	 * @param game -new game
	 */
	public void setGame(GameController game) {
		this.game = game;
	}

	/**
	 * Thread method to repeat the rotation.
	 */
	@Override
	public void run() {
		while(image.isSpin()) {
			image.rotate();
			game.updateImage();
			try {
				sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
