package model;

/**
 * Class Artist
 * It's the child of class Person.
 * It's implemented with data structure Binary Search Tree
 * @author Fernanda
 * @version May 20th 2020
 */
public class Artist extends Person implements Comparable<Artist>{
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
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return
	 */
	public String getRecordCompany() {
		return recordCompany;
	}

	/**
	 * 
	 * @param recordCompany
	 */
	public void setRecordCompany(String recordCompany) {
		this.recordCompany = recordCompany;
	}

	/**
	 * 
	 * @return
	 */
	public Artist getLeft() {
		return left;
	}

	/**
	 * 
	 * @param left
	 */
	public void setLeft(Artist left) {
		this.left = left;
	}

	/**
	 * 
	 * @return
	 */
	public Artist getRight() {
		return right;
	}

	/**
	 * 
	 * @param right
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
