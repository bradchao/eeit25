package tw.brad.api;

public class User {
	private final String name;
	private final String email;
	
	private User(UserBuilder builder) {
		this.name = builder.name;
		this.email = builder.email;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public static UserBuilder newBuilder() {
		return new UserBuilder();
	}
	
	public static class UserBuilder extends Object{
		private String name;	// required
		private String email;	// required
								// optional
		
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public User build() {
			if (name == null || email == null) throw new IllegalArgumentException("參數不對");
			return new User(this);
		}
		
	}
}
