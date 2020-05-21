package thread;

import model.Gif;
import ui.GameController;

/**
 * @version May 21th 2020
 * @author Fernanda
 * Class GifThread
 */
public class GifThread extends Thread{
	private Gif gif;
	private GameController game;
	private String gifPath;
	
	public GifThread(String gifP, GameController g) {
		gifPath= gifP;
		game= g;
	}
	
	@Override
	public void run() {
		while(true) {
			gifPath= "./src/image/music.gif";
			try {
				sleep(100);
			}catch(Exception e) {
				e.getMessage();
			}
		}
	}
}
