package util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class SoundPlayer {

	public static HashMap<String, Clip> sounds = new HashMap<>();
	public static String actualSong;

	public SoundPlayer() {

	}


	public static void addSound(String name, String path) {
		try {

			Clip sound = AudioSystem.getClip();
			sound.open(AudioSystem.getAudioInputStream(SoundPlayer.class.getResource(path)));
			sounds.put(name, sound);

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	public static void startSound(String nameSound) {

		Clip clip = sounds.get(nameSound);
		actualSong = nameSound;
		clip.start();

	}

	public static void pauseSound(String nameSound) {

		Clip clip = sounds.get(nameSound);
		clip.stop();

	}

	public static void stopSound(String nameSound) {

		Clip clip = sounds.get(nameSound);
		clip.stop();
		clip.setMicrosecondPosition(0);

	}
	
	public static void stopActualSong() {
		
		Clip clip = sounds.get(actualSong);
		clip.stop();
		clip.setMicrosecondPosition(0);
		
	}
	

	public static void nextSound(String nameSound) {
		
	
		
	}

}
