package model;

import java.io.Serializable;

/**
 * @author Fernanda
 * @version April 24th 2020
 * Class User
 */
public class User implements Serializable, Comparable<User>{
	/**
	 * constant
	 */
	private static final long serialVersionUID = 1L;

	//Attributes
	/** String that represents the name of the player*/
	private String name;

	/** String that represents the nickname that the user chooses*/
	private String nickname;

	/** String that represents the gender of the user. It can be male or female*/
	private String gender;

	/** String that represents the password of the user*/
	private String password;

	/** Cumulative integer that represents the points that a user can have in the game*/
	private int points;

	//Methods
	/**
	 * Constructor's method
	 * @param name -name of the user
	 * @param nickname -nickname that the user chooses to have in the game
	 * @param gender -gender of the user
	 * @param password -password of the user
	 * Each user just for register in the game, has 10 points already.
	 */
	public User(String name, String nickname, String gender, String password) {
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.password = password;
		points=10;
	}

	/**
	 * Overloading constructor User to user for the log in.
	 * @param nickname -nickname of the user
	 * @param password -password of the user
	 * Each user just for register in the game, has 10 points already.
	 */
	public User(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
		points=10;
	}

	/**
	 * This method gets the name of the user
	 * @return name- the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method modifies the name of the user
	 * @param name -the new name of the user
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the nickname that the user selected
	 * @return nickname- user's nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This method gets the gender of the user.
	 * @return gender- the gender of the user.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method modifies the gender of the user
	 * @param gender- the new gender of the user
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This method gets the password of the user.
	 * @return password- the password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method gets the Points of the user.
	 * @return points- the Points of the user.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * This method modifies the points of the user.
	 * @param points- the new points of the user.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * This method accumulates the points of the user, the user can get more points by playing.
	 * @param p - the points that are going to be added to the previous points of the user
	 * @return points -update the points of the user
	 */
	public int accumulatePoints(int p) {
		points= points+p;
		return points;
	}

	@Override
	public int compareTo(User u){
		return this.getNickname().compareToIgnoreCase(u.getNickname());
	}

	@Override
	public String toString() {
		return "Name: "+name+"Nickname: "+nickname+"Gender: "+gender+ "Password: "+password;
	}
}
