package model;

import java.io.Serializable;

/**
 * @author Fernanda
 * @version April 24th 2020
 * Class User
 */
public class User implements Serializable, Comparable<User>{
	//Attributes
	/** String that represents the name of the player*/
	private String name;
	
	/** String that represents the nickname that the user chooses*/
	private String nickname;
	
	/** String that represents the gender of the user. It can be male or female*/
	private String gender;
	
	/** String that represents the password of the user*/
	private String password;
	
	/** */
	private int points;
	
	//Methods
	/**
	 * 
	 * @param name
	 * @param nickname
	 * @param gender
	 * @param password
	 */
	public User(String name, String nickname, String gender, String password) {
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.password = password;
		points=10;
	}
	
	public User(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
		points=10;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public int acumulatePoints(int p) {
		points= points+p;
		return points;
	}

	@Override
	public int compareTo(User u){
		return this.getNickname().compareToIgnoreCase(u.getNickname());
	}
	
	public static void main(String[] args) {
		User user1= new User("fer", "f", "f", "1234");
		user1.acumulatePoints(10);
		System.out.println(user1.getPoints());
		
	}
	
}
