package thread;

import javax.sound.sampled.Clip;

import model.Song;
import util.SoundPlayer;

public class SongObserver extends Thread{
	private Song nextSong;

	public SongObserver(){
	}
	
	
	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}


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
