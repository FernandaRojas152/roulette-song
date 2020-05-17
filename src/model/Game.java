package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 * @version April 26th 2020
 * Class Game
 */
public class Game {
	/** association of type arraylist with object of type users*/
	private static ArrayList<User> users;
	private static User user;
	public static final String FILE = "resources/data/gameDate.txt";
	public static boolean s= false;
	
	//Methods
	/**
	 * Constructor's method
	 */
	public Game() {
		users= new ArrayList<User>();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<User> getUsers() {
		return users;
	}
	
	/**
	 * 
	 * @param users
	 */
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
			throw new UserAlreadyExistsException(user.getNickname());
		}else {
			if(!user.getName().isEmpty() && !user.getNickname().isEmpty() && !user.getGender().isEmpty() && !user.getPassword().isEmpty()) {
				users.add(user);
			}else {
				throw new RequiredFieldsException();
			}
			
			/**if(user.getNickname().compareTo(user.getNickname())>=0) {
				
			}
			*/
		}
	}
	
	/**
	 * 
	 */
	public static void save() throws IOException, FileNotFoundException{
		user= new User("fernanda", "fernanda", "fernanda", "fernanda");
		File myFile = new File(FILE);
		ObjectOutputStream oS= null;
			oS= new ObjectOutputStream(new FileOutputStream(myFile));
			oS.writeObject(user);
			oS.close();
	}
	
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public void readData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File myFile = new File(FILE);
		ObjectInputStream oS= null;
		ArrayList<User> us= null;
		
		
		if (myFile.exists()) {
			oS = new ObjectInputStream(new FileInputStream(myFile));
			us= (ArrayList<User>) oS.readObject();
			setUsers(us);
			oS.close();
			System.out.println(us);
		}
	}
	
	/**
	 * sort users by insertion
	 */
	public void sortUsers() {
		for (int i = 1; i < users.size()-1; i++) {
			for (int j = 1; j>0 && users.get(j-1).compareTo(users.get(j))>0; j--) {
				User temp= users.get(j);
				users.set(j, users.get(j-1));
				users.set(j-1,temp);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		save();
	}
}