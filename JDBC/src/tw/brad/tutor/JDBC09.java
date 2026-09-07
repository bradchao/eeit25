package tw.brad.tutor;

import tw.brad.api.BCrypt;

public class JDBC09 {

	public static void main(String[] args) {
		String passwd = "12345678";
		
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashPasswd);
		
		if (BCrypt.checkpw("12345677", hashPasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
