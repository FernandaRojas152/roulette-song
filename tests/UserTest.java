import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;

class UserTest {
	private User user;
	
	/** STAGES */ 
	public void stageUp1() {
		user= new User("Fernanda", "fernandarojas152", "femenine", "fernanda");
		user.acumulatePoints(5);
	}
	
	/** TESTS*/

	@Test
	void testAcumulatePoints() {
		stageUp1();
		user.acumulatePoints(10);
		
		assertEquals(25, user.getPoints(), "Should be 25");
	}

}
