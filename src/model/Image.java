package model;
/**
 * Class Image
 * @author Fernanda
 * @version May 15th 2020
 */
public class Image {
	//Attributes
	/** Constant angle*/
	public final static double ANGLE= 1;
	/**A double that represents the value to be rotated */
	private double rotate; 
	/** A boolean that tells the thread if the image can be rotated or not*/
	private boolean spin;
	
	//Methods
	/**
	 * Constructor's method
	 */
	public Image() {
	}
	
	/**
	 * This method gets the value of the actual angle of rotation of the image
	 * @return rotate- a double that saves the value of the angle of rotation
	 */
	public double getRotate() {
		return rotate;
	}
	
	/**
	 * This method modifies the value of the angle of the image
	 * @param rotate -the new angle of rotation
	 */
	public void setRotate(double rotate) {
		this.rotate = rotate;
	}
	
	/**
	 * This method tells if the image can be rotate or not
	 * @return spin- a boolean that it's true when it can be rotated.
	 */
	public boolean isSpin() {
		return spin;
	}
	
	/**
	 * This method modifies the value of the boolean spin, to run or stop the thread.
	 * @param spin -the new value for the boolean
	 */
	public void setSpin(boolean spin) {
		this.spin = spin;
	}
	
	/**
	 * Method to make the image rotate to simulate a real roulette.
	 */
	public void rotate() {
		setRotate(getRotate()+ANGLE);
	}


}
