package tw.brad.api;

public class Member {
	private int id;
	private String email;
	private String name;
	
	public Member(int id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
