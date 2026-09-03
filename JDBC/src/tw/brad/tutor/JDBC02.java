package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02 {

	public static void main(String[] args) {
		//String url = "jdbc:mysql://localhost/mytest?user=root&password=root&useSSL=false&characterEncoding=UTF-8";
		String url = "jdbc:mysql://localhost/brad?user=root&password=root";
		try {
			Connection conn = DriverManager.getConnection(url);
			
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO cust (cname,tel,birthday) VALUES ('Brad','123','1999-01-02')");
			
			
			
			
			System.out.println("OK4");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
