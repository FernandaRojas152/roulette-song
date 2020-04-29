package customExceptions;

public class RequiredFieldsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequiredFieldsException() {
		super("You have to fill all the fields to create your account");
	}

}
