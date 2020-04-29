package customExceptions;

public class SongAlreadyExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SongAlreadyExistsException() {
		super("This song has been already uploaded, please check it out or try again with a different song");
	}

}
