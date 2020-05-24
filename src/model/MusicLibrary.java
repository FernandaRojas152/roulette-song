package model;

import customExceptions.SongAlreadyExistsException;

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
	
	/**
	 * This method gets the first song in the doubly linked list
	 * @return first -the first song
	 */
	public Song getFirst() {
		return first;
	}

	/**
	 * This method modifies the first song in the doubly linked list.
	 * @param first -the new first song.
	 */
	public void setFirst(Song first) {
		this.first = first;
	}

	/**
	 * This method gets the last song in the doubly linked list
	 * @return last -the last song
	 */
	public Song getLast() {
		return last;
	}

	/**
	 * This method modifies the last song in the doubly linked list.
	 * @param last -the new last song.
	 */
	public void setLast(Song last) {
		this.last = last;
	}

	/**
	 * This method gets the size of the linked list
	 * @return size- actual size of the linked list.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method modifies the size of the linked list
	 * @param size -new size of the linked list
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * This method verifies if the doubly linked list it's empty, verifying it the first one it's null.
	 * @return boolean- true if list it's empty, false if list it's not empty
	 */
	public boolean isEmpty(){
		return first==null;
	}
	
	/**
	 * This method adds a new song to the doubly linked list
	 * <b> pre: The list can be null or be already filled with one or multiple nodes</b>
	 * <b> pos: list !=null </b>
	 * @param name -the name of the song
	 * @param fileP -the path of the song
	 * @throws SongAlreadyExistsException -when the user it's trying to add a song that it's already on the data
	 */
	public void addSong(String name, String fileP) throws SongAlreadyExistsException{
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
	 * This method gets the index of each node in the linked list
	 * @param i- index needed in the linked list
	 * @return index;
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
	 * This method gets the specific object at a specific index in the linked list
	 * @param i -index to be search in the list
	 * @return temp -the song that it's in the searched index.
	 * @throws NullPointerException -if list it's empty.
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
	 * This method searches a Song by its name and its path.
	 * @param name -name of the song
	 * @param fileP -path of the song
	 * @return finded -a boolean that represents if the object song was found or not.
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
