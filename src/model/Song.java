package model;

/**
 * @author Fernanda
 * @version April 26th 2020
 * Class Song
 */
public class Song {
	//Attributes
	/** */
	private Song last;
	/** */
	private Song next;
	/** */
	private String songName;
	/** */
	private String artist;
	/** */
	private String fileP;
	
	/**
	 * 
	 * @param songName
	 * @param artist
	 * @param fileP
	 */
	public Song(String songName, String artist, String fileP) {
		this.songName= songName;
		this.artist= artist;
		this.fileP= fileP;
	}
	
	/** 
	 * 
	 * @return
	 */
	public String getFileP() {
		return fileP;
	}
	
	/** 
	 * 
	 * @param fileP
	 */
	public void setFileP(String fileP) {
		this.fileP = fileP;
	}
	
	/**
	 * 
	 * @return
	 */
	public Song getLast() {
		return last;
	}
	
	/**
	 * 
	 * @param last
	 */
	public void setLast(Song last) {
		this.last = last;
	}
	
	/**
	 * 
	 * @return
	 */
	public Song getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param next
	 */
	public void setNext(Song next) {
		this.next = next;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * 
	 * @param songName
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
}
