package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.api.BCrypt;
import tw.brad.api.Member;

public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_LOGIN = """
							SELECT id, account, passwd, name
							FROM member
							WHERE account = ?
							""";
	
	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
				){
			System.out.println("Member Login");
			System.out.println("-----");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Account: ");
			String account = scanner.next();
			System.out.print("Password: ");	
			String passwd = scanner.next();
			
			Member member = login(account, passwd, pstmt);
			if (member != null) {
				System.out.printf("Welcome, %s(%d)\n", member.getName(), member.getId());
			}else {
				System.out.println("Login Failure");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	static Member login(String account, String passwd, PreparedStatement pstmt) 
		throws Exception {
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String hashPasswd = rs.getString("passwd");
			if (BCrypt.checkpw(passwd, hashPasswd)) {
				return new Member(rs.getLong("id"), rs.getString("account"),
						rs.getString("passwd"),rs.getString("name"));
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

}
