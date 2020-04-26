package customExceptions;

public class UserDoesntExistException extends Exception{
	
	public UserDoesntExistException(String name) {
	super("User"+name+"doesn't exist in the game, please verify the name and try again.");
	}
}
