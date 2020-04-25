package model;

/**
 * 
 * @author Fernanda
 * @version March 24th 2020
 * Class User
 */
public class User {
	//Attributes
	private String name;
	private String nickname;
	private String gender;
	private String password;
	
	private Points points;

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
	
}
