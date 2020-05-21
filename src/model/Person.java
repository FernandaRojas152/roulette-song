package model;
import java.io.Serializable;

/**
 * Class Person
 * It's the parent of Artist.
 * @author Fernanda
 * @version May 20th 2020
 */
public class Person implements Serializable{
	//Attributes
	/**
	 * Constant
	 */
	private static final long serialVersionUID = 1L;
	
	/** A string that represents the name of the person*/
	protected String name;
	
	//methods
	/**
	 * Constructor's method
	 * @param name
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * This method gets the name of the person
	 * @return name -person's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method modifies the name of the person
	 * @param name -the new name of the person.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
