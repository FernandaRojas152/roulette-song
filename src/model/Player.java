package model;
import java.util.Map;

import javazoom.jlgui.basicplayer.*;

/**
 * @version May 16th 2020
 * @author Fernanda
 * Class Player
 * Using JavaZoom Libraries
 */
public class Player implements BasicPlayerListener{
	public BasicPlayer player = new BasicPlayer();
	public BasicController control = (BasicController) player;
	float[] equalizador;
    float[] eq = new float[32];
	private Game game;
	
	public Player(Game g) {
		player.addBasicPlayerListener(this);
		game= g;
	}
	@Override
	public void opened(Object arg0, Map arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void progress(int i, long l, byte[] b, Map p) {
		equalizador= (float[]) p.get("mp3.equalizer");
		
	}

	@Override
	public void setController(BasicController arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateUpdated(BasicPlayerEvent arg0) {
		if(player.getStatus() == BasicPlayer.STOPPED && game.s== false) {
			//game.next();
		}
	}
	
	

}
