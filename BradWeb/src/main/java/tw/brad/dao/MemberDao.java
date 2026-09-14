package tw.brad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tw.brad.api.BCrypt;
import tw.brad.api.Member;
import tw.brad.listener.InitListener;

public class MemberDao {
	private static final String SQL_LOGIN = """
			SELECT id, account, passwd, name, icon, bike
			FROM member
			WHERE account = ?
			""";
	public Member login(String account, String passwd) throws Exception {
		try(Connection conn = InitListener.getDataSource().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN)){
			pstmt.setString(1, account);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next() && BCrypt.checkpw(passwd, rs.getString("passwd"))) {
					return new Member(
							rs.getLong("id"), 
							rs.getString("account"), 
							rs.getString("passwd"), 
							rs.getString("name"), null, null);
				}
			}
		}
		return null;
	}
	
	
	
}
