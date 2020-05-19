package model;

/**
 * binary search tree
 * @author Fernanda
 *
 */
public class Artist implements Comparable<Artist>{
	private String country;
	private String recordCompany;
	private Artist left;
	private Artist right;
	
	
	public Artist(String country, String recordCompany) {
		super();
		this.country = country;
		this.recordCompany = recordCompany;
	}
	

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRecordCompany() {
		return recordCompany;
	}


	public void setRecordCompany(String recordCompany) {
		this.recordCompany = recordCompany;
	}


	public Artist getLeft() {
		return left;
	}


	public void setLeft(Artist left) {
		this.left = left;
	}


	public Artist getRight() {
		return right;
	}


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
