package model;

import java.io.Serializable;

/**
 * Class Artist
 * It's the child of class Person.
 * It's implemented with data structure Binary Search Tree
 * @author Fernanda
 * @version May 20th 2020
 */
public class Artist extends Person implements Comparable<Artist>, Serializable{
	/**
	 * constant
	 */
	private static final long serialVersionUID = 1L;
	//Attributes
	/** A string that represents the country where the artist belongs */
	private String country;
	/** A string that represents the record label that the artist has been affiliate*/
	private String recordCompany;
	/** left leaf of the binary search tree*/
	private Artist left;
	/** right leaf of the binary search tree*/
	private Artist right;
	
	//Methods
	/**
	 * Constructor's method
	 * @param name -name of the artist
	 * @param country- country of the artist
	 * @param recordCompany- record company of the artist
	 */
	public Artist(String name, String country, String recordCompany) {
		super(name);
		this.country = country;
		this.recordCompany = recordCompany;
	}
	
	/**
	 * This method gets the country of the artist
	 * @return country -the respective country for the artist
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * This method modifies the country that the user has.
	 * @param country -the new string with the country.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * This method gets the record label of the artist
	 * @return recordCompany -the record label of the artist
	 */
	public String getRecordCompany() {
		return recordCompany;
	}

	/**
	 * This method modifies the record label of the artist, for a new record label or just a correction
	 * @param recordCompany -the new record label name.
	 */
	public void setRecordCompany(String recordCompany) {
		this.recordCompany = recordCompany;
	}

	/**
	 * This method gets the left leafs on the tree.
	 * @return left -an object of type artist that represents the left leaf.
	 */
	public Artist getLeft() {
		return left;
	}

	/**
	 * This method modifies any left leaf within the tree
	 * @param left -the new value of the leaf
	 */
	public void setLeft(Artist left) {
		this.left = left;
	}

	/**
	 * This method gets the right leafs on the tree.
	 * @return right -an object of type artist that represents the right leaf.
	 */
	public Artist getRight() {
		return right;
	}

	/**
	 * This method modifies any right leaf within the tree
	 * @param right -the new value of the leaf
	 */
	public void setRight(Artist right) {
		this.right = right;
	}


	@Override
	public int compareTo(Artist artist) {
		int c;
		if(this.recordCompany.compareToIgnoreCase(artist.recordCompany)>0) {
			c= 1;
		}else if(this.recordCompany.compareToIgnoreCase(artist.recordCompany)>0) {
			c= -1;
		}else {
			c=0;
		}
		return c;
	}
	
	
}
