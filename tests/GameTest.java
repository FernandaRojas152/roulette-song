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
	
	/** STAGES */
	public void setUpStage1() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		game.addUser(user);
	}
	
	public void setUpStage2() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
	}
	
	public void setUpStage3() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		User user2= new User("Angelica","angelica2013", "femenine", "angelica");
		game.addUser(user);
		game.addUser(user2);
	}
	
	public void setUpStage4() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		User user2= new User("Angelica","angelica2013", "femenine", "angelica");
		User user3= new User("Amanda","amandaR", "femenine", "angelica");
		User user4= new User("Saru","saruhiko", "male", "angelica");
		game.addUser(user);
		game.addUser(user2);
		game.addUser(user3);
		game.addUser(user4);
	}
	
	public void setUpStage5() throws UserAlreadyExistsException, RequiredFieldsException {
		game= new Game();
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
	}
	
	
	/** TESTS */
	@Test
	void testUserExists() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage1();
		try {
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
	
	@Test
	void testEmptyUser() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage2();
		Assertions.assertThrows(UserDoesntExistException.class, () ->game.searchUser("fer"), "Should throw an exception");
	}
	
	@Test
	void testFillData() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage5();		
		try {
			User userP= new User("", "amandaRojas", "", "amanda");
			game.addUser(userP);
		} catch (RequiredFieldsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testSortUser() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage4();
		game.sortUsers();
		System.out.println(game.getUsers().get(0).getNickname());
		assertEquals("angelica2013", game.getUsers().get(0).getNickname());
	}
	
	@Test
	void testSearchUser() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage3();
		try {
			User userT= game.searchUser("angelica2013");
			assertEquals("angelica2013", userT.getNickname());
		} catch (UserDoesntExistException e) {
			e.getMessage();
		}
	}
	
	@Test
	void testSearchUserWrong() throws UserAlreadyExistsException, RequiredFieldsException {
		setUpStage3();
		try {
			User userT= game.searchUser("king");
			assertEquals("king", userT.getNickname());
		} catch (UserDoesntExistException e) {
			System.out.println(e.getMessage());
		}
	}
}
