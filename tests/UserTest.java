import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;

/**
 * Class UserTest
 * @author Fernanda
 * @version May 24th 2020
 */
class UserTest {
	private User user;
	
	/** STAGES */ 
	public void stageUp1() {
		user= new User("Fernanda", "fernandarojas152", "femenine", "fernanda");
		user.accumulatePoints(5);	
	}
	
	public void stageUp2() {
		user= new User("Fernanda", "fernandarojas152", "femenine", "fernanda");
		user.accumulatePoints(10);
		user.setPoints(user.getPoints()-20);
	}
	
	/** TESTS*/

	@Test
	void testAcumulatePoints() {
		stageUp1();
		user.accumulatePoints(10);
		
		assertEquals(25, user.getPoints(), "Should be 25");
	}
	
	@Test
	void testSpendPoints() {
		stageUp2();
		
		assertEquals(0, user.getPoints(), "Should be 0");
	}
}
