package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_INSERT = """
							INSERT INTO cust (cname,tel,birthday) 
							VALUES ('Eric1','123','1999-01-02'),
							('Eric2','123','1999-01-02'),
							('Eric3','123','1999-01-02'),
							('Eric4','123','1999-01-02'),
							('Eric5','123','1999-01-02')
							""";

	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
			Statement stmt = conn.createStatement();){
			
			stmt.execute(SQL_INSERT);
			
			System.out.println("OK6");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
