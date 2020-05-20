package model;

/**
 * Class Genre (uses linked list)
 * @author Fernanda
 * @version May 20th 2020
 */
public class Genre {
	private String name;
	private String rythm;
	private int duration;
	
	private Genre next;

	public Genre(String name, String rythm, int duration) {
		this.name = name;
		this.rythm = rythm;
		this.duration= duration;
	}
	
	public Genre(int duration) {
		this.duration= duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRythm() {
		return rythm;
	}

	public void setRythm(String rythm) {
		this.rythm = rythm;
	}

	public Genre getNext() {
		return next;
	}

	public void setNext(Genre next) {
		this.next = next;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
