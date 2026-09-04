package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC06 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL = """
							SELECT id, cname myname, tel, birthday 
							FROM cust
							""";

	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
				){
			
			while (rs.next()) {
				String c1 =  rs.getString("id");
				String c2 =  rs.getString("myname");
				String c3 =  rs.getString("birthday");
				System.out.printf("%s:%s:%s\n", c1, c2, c3);
			}
			
			
			System.out.println("OK8");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
