package model;

import java.util.ArrayList;

/**
 * @author Fernanda
 * @version March 26th 2020
 * Class Game
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
	 * This method will search if the userExists already has been registered and exists in the game.
	 * @param nickname -name that the user has and it's going to be the one that it's going to be
	 * used to verified.
	 * @return exists -true if it exists and false if it doesn't
	 */
	public boolean userExists(String nickname) {
		boolean exists= false;
		int initial=0;
		int end= users.size()-1;
		
		while(initial<= end && !exists) {
			
			int mid= (initial+end)/2;
			
			if(users.get(mid).getNickname().equalsIgnoreCase(nickname)) {
				exists= true;
			}else if(users.get(mid).getNickname().compareToIgnoreCase(nickname)<0) {
				
				initial= mid+1;
				
			}else {
				end= mid-1;
			}
		}
		return exists;
	}
	
	public User searchUser() {
		return null;
		
	}
}
