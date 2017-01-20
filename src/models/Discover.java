package models;

public class Discover {
	String image;
	int id;
	String title;
	public Discover(String image, int id, String title) {
		super();
		this.image = image;
		this.id = id;
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
