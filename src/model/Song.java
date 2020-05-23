package model;

/**
 * @author Fernanda
 * @version April 26th 2020
 * Class Song
 */
public class Song implements Comparable<Song>{
	//Attributes
	/** Previous song in the doubly linked list*/
	public Song prev;
	/** Next song in the doubly linked list*/
	public Song next;
	/** A String that represents the name of the song*/
	public String songName;
	/** A string that saves the path of the song added*/
	public String fileP;
	
	//Methods
	/**
	 * Constructor's method
	 * @param songName -the name of the song.
	 * @param fileP -the file path of the song.
	 */
	public Song(String songName, String fileP) {
		this.songName= songName;
		this.fileP= fileP;
	}
	
	/** 
	 * This method gets the file path
	 * @return fileP -path of the song
	 */
	public String getFileP() {
		return fileP;
	}
	
	/**
	 * This method gets the previous song.
	 * @return prev -object that represents the previous song
	 */
	public Song getprev() {
		return prev;
	}
	
	/**
	 * This method modifies the previous song in the list.
	 * @param prev -the new previous.
	 */
	public void setprev(Song prev) {
		this.prev = prev;
	}
	
	/**
	 * This method gets the next song.
	 * @return next -object that represents the next song
	 */
	public Song getNext() {
		return next;
	}
	
	/**
	 * This method modifies the next song.
	 * @return next -object that represents the next song
	 */
	public void setNext(Song next) {
		this.next = next;
	}
	
	/**
	 * This method gets the name of the song
	 * @return songName -String for the name
	 */
	public String getSongName() {
		return songName;
	}

	@Override
	public int compareTo(Song song) {
		int c=0;
		if(this.songName.compareToIgnoreCase(song.songName)> 0) {
			c=1;
		}else if(this.songName.compareToIgnoreCase(song.songName) <0) {
			c=-1;
		}else{
			c=0;
		}
		return c;
	}
}
