package model;
/**
 * @version May 25th 2020
 * @author Fernanda
 * Class Songwriter
 */
public class Songwriter extends Person implements Comparable<Songwriter>{
	/**
	 * constant
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String country;

	private Songwriter left;
	private Songwriter right;
	
	public Songwriter(String name, String type, String country) {
		super(name);
		this.type= type;
		this.country= country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Songwriter getLeft() {
		return left;
	}

	public void setLeft(Songwriter left) {
		this.left = left;
	}

	public Songwriter getRight() {
		return right;
	}

	public void setRight(Songwriter right) {
		this.right = right;
	}

	@Override
	public int compareTo(Songwriter writer) {
		int c;
		if(this.type.compareToIgnoreCase(writer.type)>0) {
			c= 1;
		}else if(this.type.compareToIgnoreCase(writer.type)>0) {
			c= -1;
		}else {
			c=0;
		}
		return c;
	}
}
