package models;

public class MovieCast {

	int cast_id;
	String character;
	int person_id;
	String name;
	String image;
	public MovieCast(int cast_id, String character, int person_id, String name,
			String image) {
		super();
		this.cast_id = cast_id;
		this.character = character;
		this.person_id = person_id;
		this.name = name;
		this.image = image;
	}
	public int getCast_id() {
		return cast_id;
	}
	public void setCast_id(int cast_id) {
		this.cast_id = cast_id;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
