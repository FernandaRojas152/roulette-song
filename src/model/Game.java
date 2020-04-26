package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import customExceptions.RequiredFieldsException;
import customExceptions.UserAlreadyExistsException;
import customExceptions.UserDoesntExistException;

/**
 * @author Fernanda
 * @version March 26th 2020
 * Class Game
 */
public class Game {

	private ArrayList<User> users;

	public Game() {
		users= new ArrayList<User>();
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

	/**
	 * This method will search the user that the client wants to see
	 * @param nickname -name of the user that it's going to be searched.
	 * @return temp -the user searched.
	 * @throws UserDoesntExistException -it's thrown when the user searched it's not found. 
	 */
	public User searchUser(String nickname) throws UserDoesntExistException{
		User temp= null;
		int initial= 0;
		int end= users.size()-1;

		while(initial<= end && temp== null) {
			int mid= (initial+end)/2;

			if(users.get(mid).getNickname().equalsIgnoreCase(nickname)) {
				temp= users.get(mid);

			}else if(users.get(mid).getNickname().compareTo(nickname)<0) {
				initial= mid+1;
			}else {
				end= end-1;
			}
		}

		if(temp== null) {
			throw new UserDoesntExistException(nickname);
		}

		return temp;
	}

	/**
	 * 
	 * <b> pre: </b>
	 * <b> post: </b>
	 * @param user
	 * @throws UserAlreadyExists
	 * @throws RequiredFieldsException
	 */
	public void addUser(User user) throws UserAlreadyExistsException, RequiredFieldsException{
		if(userExists(user.getNickname())) {
			throw new UserAlreadyExistsException();
		}else {
			if(!user.getName().isEmpty() && !user.getNickname().isEmpty() && !user.getGender().isEmpty() && !user.getPassword().isEmpty()) {
				users.add(user);
			}else {
				throw new RequiredFieldsException();
			}
		}
	}
	
	/**
	 * 
	 */
	public void save() {
		FileOutputStream fS= null;
		ObjectOutputStream oS= null;
		
		try {
			fS = new FileOutputStream("./data/gameData.dat");
			oS= new ObjectOutputStream(fS);
			
			oS.writeObject(users);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(users!=null) {
					fS.close();
				}
				if(oS!=null) {
					oS.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	/**
	 * 
	 */
	public void readData() {
		FileInputStream fS= null;
		ObjectInputStream oS= null;
		
		ArrayList<User> us= null;
		
		try {
			fS = new FileInputStream("./data/gameData.dat");
			oS= new ObjectInputStream(fS);
			us= (ArrayList<User>) oS.readObject();
			setUsers(us);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(fS!=null) {
					fS.close();
				}
				
				if(oS!=null) {
					oS.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
			
		}
	}
	
	/**
	 * 
	 */
	/**public void sortUsers() {
		for (int i = 1; i < users.size()-1; i++) {
			for (int j = 1; j>0 && users.get(j-1).compareTo(users.get(j))>0; j--) {
				User temp= users.get(j);
				users.set(j, users.get(j-1));
				users.set(j-1,temp);
			}
		}
		
	}
	*/
}
