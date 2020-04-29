package customExceptions;

public class InsufficientPointsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientPointsException() {
		super("You don't have enough points to buy a song, play a little more so you can get the song you want! :)");
	}

}
