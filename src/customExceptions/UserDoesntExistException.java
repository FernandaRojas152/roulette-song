package customExceptions;

public class UserDoesntExistException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDoesntExistException(String name) {
	super("User "+name+" doesn't exist in the game, please verify the name and try again.");
	}
}
