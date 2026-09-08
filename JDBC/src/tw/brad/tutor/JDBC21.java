package tw.brad.tutor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import tw.brad.api.BCrypt;
import tw.brad.api.JdbcToolV2;
import tw.brad.api.Member;
import tw.brad.api.RowMapper;

public class JDBC21 {
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
	private static JdbcToolV2 jdbc = new JdbcToolV2();
	
	public static void main(String[] args) {
		
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
		
		
		if (!isAccountExist(SQL_CHECK1, account)) {
			if (registerMember(account,passwd,name)) {
				System.out.println("Register SUCCESS");
			}else {
				System.out.println("Register FAILURE");
			}
		}else {
			System.out.println("ERROR: Account EXIST");
		}
		
	}
	
	
	static boolean isAccountExist(String sql, String account){
		List<Member> members = jdbc.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs) throws SQLException {
				return new Member();
			}
		}, account);
		return members.size() > 0;
	}
	
	
	static boolean registerMember(String account, String passwd, String name) {
		
		int n = jdbc.update(SQL_REGISTER, account, BCrypt.hashpw(passwd, BCrypt.gensalt()), name);
		
		return n > 0;
	}
	
	
	
	
	

}
