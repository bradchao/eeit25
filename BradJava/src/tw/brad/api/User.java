package tw.brad.api;

public class User {
	private final String name; // required
	private final String email;// required
	private final int age;		// optional
	
	private User(UserBuilder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.age = builder.age;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}

	public static UserBuilder newBuilder() {
		return new UserBuilder();
	}
	
	public static class UserBuilder extends Object{
		private String name;	
		private String email;	// required
		private int age;						
		
		private UserBuilder() {
			age = 18;
		}
		
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public User build() {
			if (name == null || email == null) throw new IllegalArgumentException("參數不對");
			return new User(this);
		}
		
	}
}
