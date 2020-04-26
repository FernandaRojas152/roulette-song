package model;

import java.util.ArrayList;

/**
 * 
 * @author Fernanda
 * March 26th 2020
 */
public class Game {
	
	private ArrayList<User> users;
	
	public Game() {
		users= new ArrayList<>();
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	/**
	 * 
	 * @param nickname
	 * @return
	 */
	public boolean userExists(String nickname) {
		boolean exists= false;
		
		int initial=0;
		int end= users.size()-1;
		
		while(initial<= end && !exists) {
			
		}
		
		return exists;
	}
}
