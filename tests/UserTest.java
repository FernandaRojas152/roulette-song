import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;

class UserTest {
	private User user;
	
	/** STAGES */ 
	public void stageUp1() {
		user= new User("Fernanda", "fernandarojas152", "femenine", "fernanda");
		user.acumulatePoints(10);
	}
	
	/** TESTS*/
	/**
	@Test
	void testAcumulatePoints() {
		assertEquals(30, user.acumulatePoints(10), "Should be 30");
		
	}
	*/
}
