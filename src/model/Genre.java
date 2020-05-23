package model;

/**
 * Class Genre (uses linked list)
 * @author Fernanda
 * @version May 20th 2020
 */
public class Genre {
	//Attributes
	/** String that represents the name of the player*/
	private String name;
	/** String that represents the rythm of the player*/
	private String rythm;
	/** Integer that represents the duration of the player*/ 
	private int duration;
	/** Indicates the next node on the linked list*/
	
	private Genre next;
	
	//Methods
	/**
	 * Constructor's method
	 * @param name -name of the genre. 
	 * @param rythm -rythm of the genre.
	 * @param duration -duration of the genre.
	 */
	public Genre(String name, String rythm, int duration) {
		this.name = name;
		this.rythm = rythm;
		this.duration= duration;
	}
	
	/**
	 * Overloading constructor's method
	 * @param duration -duration of the genre.
	 */
	public Genre(int duration) {
		this.duration= duration;
	}
	
	/**
	 * This method gets the name of the genre
	 * @return name- the name of the genre
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method modifies the name of the genre
	 * @param name -the new name of the genre
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method gets the rythm of the genre
	 * @return rythm- the rythm of the genre
	 */
	public String getRythm() {
		return rythm;
	}
	
	/**
	 * This method modifies the rythm of the genre
	 * @param rythm -the new rythm of the genre
	 */
	public void setRythm(String rythm) {
		this.rythm = rythm;
	}
	
	/**
	 * This method gets the next of the linked list
	 * @return next- the next of the linked list
	 */
	public Genre getNext() {
		return next;
	}
	
	/**
	 * This method modifies the next of the linked list
	 * @param rythm -the new rythm of the linked list 
	 */
	public void setNext(Genre next) {
		this.next = next;
	}
	
	/**
	 * This method gets the duration of the genre
	 * @return duration -genre's duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * This method modifies the duration of the genre
	 * @param duration -the new duration of the genre.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
