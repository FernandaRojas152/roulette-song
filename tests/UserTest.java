import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;

class UserTest {
	private User user;
	
	//Stages
	public void setUpStage1() {
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
	}
	
	public void setUpStage2() {
		user= new User(null, null, null, null);
	}
	
	public void setUpStage3() {
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		User user2= new User("Angelica","fernandarojas152", "femenine", "angelica");
	}
	
	public void setUpStage4() {
		user= new User("Fernanda", "fernandarojas152", "feminine", "fernanda");
		User user2= new User("Angelica","angelica2013", "femenine", "angelica");
	}
	
	public void setUpStage5() {
		user= new User(null, "fernandarojas152", null, "fernanda");
	}
	
	
	//tests
	@Test
	void testUserExists() {
		fail("Not yet implemented");
	}

}
