package model;

/**
 * 
 * @author Fernanda
 * @version March 24th 2020
 * Class User
 */
public class User implements Comparable<User>{
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
	private Points points;
	
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
		points= null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Points getPoints() {
		return points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}

	@Override
	public int compareTo(User u) {
		return this.getNickname().compareToIgnoreCase(u.getNickname());
	}
	
}
