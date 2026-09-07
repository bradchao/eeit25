package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.api.BCrypt;

public class JDBC10 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_REGISTER = """
							INSERT INTO member
							(account,passwd,name)
							VALUES
							(?,?,?)
							""";
	private static final String SQL_CHECK1 = """
							SELECT account
							FROM member
							WHERE account = ?
							""";
	private static final String SQL_CHECK2 = """
							SELECT COUNT(account) count
							FROM member
							WHERE account = ?
							""";
	
	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmtCheck1 = conn.prepareStatement(SQL_CHECK1);
				PreparedStatement pstmtCheck2 = conn.prepareStatement(SQL_CHECK2);
				PreparedStatement pstmtRegister = conn.prepareStatement(SQL_REGISTER);
				){
			System.out.println("Member Register");
			System.out.println("-----");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Account: ");
			String account = scanner.next();
			System.out.print("Password: ");
			String passwd = scanner.next();
			System.out.print("Name: ");
			String name = scanner.next();
			System.out.println("-----");
			
			if (!isAccountExist(account, pstmtCheck1)) {
				if (registerMember(account,passwd,name, pstmtRegister)) {
					System.out.println("Register SUCCESS");
				}else {
					System.out.println("Register FAILURE");
				}
			}else {
				System.out.println("ERROR: Account EXIST");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	static boolean isAccountExist(String account, PreparedStatement pstmt) throws Exception{
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
	
	
	static boolean registerMember(String account, String passwd, String name, PreparedStatement pstmt) 
		throws Exception {
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, name);
		
		return pstmt.executeUpdate() > 0;
	}
	
	
	
	
	

}
