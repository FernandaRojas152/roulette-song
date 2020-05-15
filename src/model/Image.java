package model;
/**
 * 
 * @author Fernanda
 * @version May 15th 2020
 */
public class Image {

	public final static double ANGLE= 1;
	private double rotate;
	private boolean spin;

	public Image() {
	}

	public double getRotate() {
		return rotate;
	}

	public void setRotate(double rotate) {
		this.rotate = rotate;
	}

	public boolean isSpin() {
		return spin;
	}

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
