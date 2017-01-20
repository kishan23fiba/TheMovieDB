package models;

public class Videos {
	String id;
	String key;
	String name;
	public Videos(String id, String key, String name) {
		super();
		this.id = id;
		this.key = key;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
