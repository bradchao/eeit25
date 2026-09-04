package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {

	public static void main(String[] args) {
		//String url = "jdbc:mysql://localhost/mytest?user=root&password=root&useSSL=false&characterEncoding=UTF-8";
		//String url = "jdbc:sqlserver://localhost:1443;databaseName=brad;encrypt=true;trustServerCertificate=true;";
		
		
		//String url = "jdbc:mysql://localhost:3306/brad?user=root&password=root";
		String url = "jdbc:mysql://localhost:3306/brad";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", "false");
		prop.put("characterEncoding", "UTF-8");
		
		try {
			//Connection conn = DriverManager.getConnection(url);
			//Connection conn = DriverManager.getConnection(url,"root","root");
			Connection conn = DriverManager.getConnection(url,prop);
			
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO cust (cname,tel,birthday) VALUES ('Brad4','123','1999-01-02')");
			
			
			
			
			System.out.println("OK4");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
