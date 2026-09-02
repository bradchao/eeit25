package tw.brad.tutor;

import tw.brad.api.User;

public class Brad55 {

	public static void main(String[] args) {
		User user = User.newBuilder()
					.email("brad@brad.tw")
					.age(30)
					.name("brad")
					.build();
		System.out.println(user.getEmail());
		System.out.println(user.getName());
		System.out.println(user.getAge());
	}

}
