package thread;

import javax.sound.sampled.Clip;

import model.MusicLibrary;
import model.Song;
import util.SoundPlayer;

/**
 * @version May 22th 2020
 * @author Fernanda Class SongObserver
 */
public class SongObserver extends Thread {
	/** Next song in the doubly linked list */
	private MusicLibrary music;

	/**
	 * Constructor's method
	 * @param music -the music to be updated
	 */
	public SongObserver(MusicLibrary music) {
		setDaemon(true);
		this.music = music;
	}

	/**
	 * This method makes that the songs sounds one by one.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				sleep(1);
				Clip actual = SoundPlayer.sounds.get(SoundPlayer.actualSong);
				if (SoundPlayer.actualSong != null && !SoundPlayer.actualSong.equals("")) {
					if (actual.getMicrosecondPosition() == actual.getMicrosecondLength()) {
						SoundPlayer.stopActualSong();
						Song next = music.findSongByName(SoundPlayer.actualSong).getNext();
						if(next != null) {
						SoundPlayer.startSound(next.getSongName());
						System.out.println("Reproduciendo "+ next.getSongName());
						}else {
							System.out.println("Ya no hay canciones");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
