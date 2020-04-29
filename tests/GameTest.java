import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import customExceptions.RequiredFieldsException;
import customExceptions.UserAlreadyExistsException;
import customExceptions.UserDoesntExistException;
import model.Game;
import model.User;

class GameTest {
	private Game game;
	private User user;
	
	//Stages
	public void setUpStage1() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		game.addUser(user);
		
	}
	
	public void setUpStage2() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User(null, null, null, null);
		game.addUser(user);
	}
	
	public void setUpStage3() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		User user2= new User("Angelica","fernandarojas152", "femenine", "angelica");
		game.addUser(user);
		game.addUser(user2);
	}
	
	public void setUpStage4() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		User user2= new User("Angelica","angelica2013", "femenine", "angelica");
		game.addUser(user);
		game.addUser(user2);
	}
	
	public void setUpStage5() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User(null, "fernandarojas152", null, "fernanda");
		game.addUser(user);
	}
	
	
	//tests
	@Test
	void testUserExists() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage1();
		try {
			//User userP= new User("Amanda", "amandaRojas", "femenine", "amanda");
			User user2= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
			game.addUser(user2);
			
		} catch (UserAlreadyExistsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testUserDoesntExists() throws UserDoesntExistException, UserAlreadyExistsException, RequiredFieldsException {
		setUpStage1();
		try {
			game.searchUser("angelica");
		} catch (UserDoesntExistException e) {
			assertTrue(true);
		}
		
	}
}
