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
	/** 
	 * This method gets the type of writer. It can be Lyricist, composer, songwriter, jingle writer, and so on... 
	 * @return type -type of writer
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * This method modifies the type of writer.
	 * @param type -the new type for the writer
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * This method gets the left leaf in the tree
	 * @return left -the left leafs in the tree
	 */
	public Songwriter getLeft() {
		return left;
	}
	
	/**
	 * This method modifies any left leaf within the tree
	 * @param left -the new value of the leaf
	 */
	public void setLeft(Songwriter left) {
		this.left = left;
	}
	
	/**
	 * This method gets the right leafs on the tree.
	 * @return right -an object of type songwriter that represents the right leaf.
	 */
	public Songwriter getRight() {
		return right;
	}
	
	/**
	 * This method modifies any right leaf within the tree
	 * @param right -the new value of the leaf
	 */
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
