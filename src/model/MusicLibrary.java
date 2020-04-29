package model;

public class MusicLibrary {
	private Song first;
	private Song last;
	private int size;
	
	public MusicLibrary() {
		first= last = null;
		size= 0;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void addSong(String name, String artist, String fileP) {
		Song temp= new Song(name, artist, fileP);
		
		
	}
	
	public int index() {
		return 0;
	}
	
	public Song getSong() {
		return null;
	}
	
	public void delete() {
		
	}
	
	public boolean search() {
		return false;
	}
	
}
