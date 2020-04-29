package customExceptions;

public class UserAlreadyExistsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String nickname) {
		super("Nickname "+nickname+" already exists in the game, please try again with a different one.");
	}
}