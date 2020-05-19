package model;
/**
 * @author Fernanda
 * @version April 30th 2020
 * Class MusicLibrary
 */
public class MusicLibrary{
	//Attributes
	/** first song of the doubly linked list*/
	public Song first;
	/** last song of the doubly linked list*/
	private Song last;
	/** list's size*/
	private int size;
	
	//Methods
	/**
	 * Constructor's method
	 */
	public MusicLibrary() {
		first= last = null;
		size= 0;
	}
	
	
	
	public Song getFirst() {
		return first;
	}



	public void setFirst(Song first) {
		this.first = first;
	}



	public Song getLast() {
		return last;
	}



	public void setLast(Song last) {
		this.last = last;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	/**
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public boolean isEmpty() throws NullPointerException{
		return first==null;
	}
	
	/**
	 * 
	 * @param name
	 * @param artist
	 * @param fileP
	 */
	public void addSong(String name, String fileP) {
		Song temp= new Song(name, fileP);
		if(isEmpty()==true) {
			first= temp;
			last= temp;
		}else {
			temp.prev= last;
			last.next= temp;
			last= temp;
		}
		size++;
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
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
	
	/**
	 * 
	 * @param i
	 * @return
	 * @throws NullPointerException
	 */
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
	
	/**
	 * 
	 * @param name
	 * @param artist
	 * @param fileP
	 * @return
	 */
	public boolean search(String name,String fileP) {
		boolean finded= false;
		Song temp= first;
		while (temp!= null) {
			if (temp.getSongName().equals(name) && temp.getFileP().equals(fileP)) {
				finded= true;
			}
			temp= temp.getNext();
		}
		return finded;
	}
}
