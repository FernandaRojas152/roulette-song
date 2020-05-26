package model;
/**
 * @version May 25th 2020
 * @author Fernanda
 * Class Songwriter
 */
public class Songwriter extends Genre implements Comparable<Songwriter>{
	/** type of song writer*/
	private String type;
	/** left leaf in the tree*/
	private Songwriter left;
	/** right leaf in the tree*/
	private Songwriter right;

	/**
	 * Constructor's method
	 * @param name -the name of the writer
	 * @param rythm -type of rhythm he uses
	 * @param duration -duration of the songs
	 * @param type -type of writer
	 */
	public Songwriter(String name, String rythm, int duration, String type) {
		super(name, rythm, duration);
		this.type= type;
	}
	
	//getters and setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
