package model;

/**
 * 
 * @author Fernanda
 * @version March 26th 2020
 * Class Song
 */
public class Song {
	
	//Attributes
	private Song last;
	
	private Song next;
	
	private String songName;
	private String artist;
	private String fileP;
	
	public Song(String songName, String artist, String fileP) {
		this.songName= songName;
		this.artist= artist;
		this.fileP= fileP;
	}

	public String getFileP() {
		return fileP;
	}

	public void setFileP(String fileP) {
		this.fileP = fileP;
	}

	public Song getLast() {
		return last;
	}

	public void setLast(Song last) {
		this.last = last;
	}

	public Song getNext() {
		return next;
	}

	public void setNext(Song next) {
		this.next = next;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
