package thread;

import javax.sound.sampled.Clip;

import model.Song;
import util.SoundPlayer;
/**
 * @version May 22th 2020
 * @author Fernanda
 * Class SongObserver
 */
public class SongObserver extends Thread{
	/** Next song in the doubly linked list*/
	private Song nextSong;
	
	/**
	 * Constructor's method
	 */
	public SongObserver(){
	}
	
	/**
	 * This method modifies the next song.
	 * @return nextSong -object that represents the next song
	 */
	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}

	/**
	 * This method makes that the songs sounds one by one.
	 */
	@Override
	public void run(){
		while(true){
			try{
				sleep(1);
				Clip actual= SoundPlayer.sounds.get(SoundPlayer.actualSong);
				if(SoundPlayer.actualSong != null && !SoundPlayer.actualSong.equals("")) {
					if(actual.getMicrosecondPosition() == actual.getMicrosecondLength()) {
						SoundPlayer.stopActualSong();
						SoundPlayer.startSound(nextSong.getSongName());
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
