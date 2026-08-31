package tw.brad.api;

import java.util.Objects;

public class Member {
	private int id;
	private String email;
	private String name;
	
	public Member(int id, String email) {
		this.id = id;
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode()");
		return Objects.hash(id, email);
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals()");
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Member member = (Member)obj;
		return id == member.id && email.equals(member.email);
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
