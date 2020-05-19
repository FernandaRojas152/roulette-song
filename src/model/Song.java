package model;

/**
 * @author Fernanda
 * @version April 26th 2020
 * Class Song
 */
public class Song implements Comparable<Song>{
	//Attributes
	/** */
	public Song prev;
	/** */
	public Song next;
	/** */
	public String songName;
	/** */
	public String fileP;
	
	/**
	 * 
	 * @param songName
	 * @param artist
	 * @param fileP
	 */
	public Song(String songName, String fileP) {
		this.songName= songName;
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
	public Song getprev() {
		return prev;
	}
	
	/**
	 * 
	 * @param prev
	 */
	public void setprev(Song prev) {
		this.prev = prev;
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
