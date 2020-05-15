package thread;

import model.Image;
import ui.GameController;

/**
 * @version May 15th 2020
 * @author Fernanda
 * Class ImageThread
 */
public class ImageThread extends Thread{
	private Image image;
	private GameController game;

	public ImageThread(Image image, GameController game) {
		super();
		this.image = image;
		this.game = game;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public GameController getGame() {
		return game;
	}

	public void setGame(GameController game) {
		this.game = game;
	}

	/**
	 * Thread method to repeat the rotation.
	 */
	public void run() {
		while(image.isSpin()) {
			image.rotate();
			game.updateImage();
			try {
				sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
