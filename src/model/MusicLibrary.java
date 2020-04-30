package model;

/**
 * @author Fernanda
 * @version April 30th 2020
 */
public class MusicLibrary {
	private Song first;
	private Song last;
	private int size;
	
	public MusicLibrary() {
		first= last = null;
		size= 0;
	}
	
	public boolean isEmpty() throws NullPointerException{
		return first==null;
	}
	
	public void addSong(String name, String artist, String fileP) {
		Song temp= new Song(name, artist, fileP);
		if(isEmpty()==true) {
			first= temp;
			last= first;
		}else {
			temp.setLast(last);
			last.setNext(temp);
			last= temp;
		}
		size++;
	}
	
	public int index(Song i) {
		Song temp= first;
		int c=0;
		while (temp!= null) {
			if(temp== i) {
				return c;
			}
			temp= temp.getNext();
			c++;
			
		}
		return -1;
	}
	
	public Song getSong(int i) throws NullPointerException{
		if(i<0 || i>= size) {
			return null;
		}
		
		int n=0;
		Song temp= first;
		while(n!=i) {
			temp= temp.getNext();
			n++;
		}
		return temp;
	}
	
	public boolean search(String name, String artist, String fileP) {
		boolean finded= false;
		Song temp= first;
		while (temp!= null) {
			if (temp.getSongName().equals(name) && temp.getArtist().equals(artist) && temp.getFileP().equals(fileP)) {
				finded= true;
			}
			temp= temp.getNext();
		}
		return finded;
	}
	
}
