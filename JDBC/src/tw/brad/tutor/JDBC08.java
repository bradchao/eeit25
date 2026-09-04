package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_QUERY1 = """
							SELECT * 
							FROM food
							WHERE city = ?
							""";
	private static final String SQL_QUERY2 = """
							SELECT * 
							FROM food
							WHERE city = 
							""";

	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("縣市? ");
//		String qcity = scanner.next();
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY1);
				){

			String qcity = "宜蘭縣";
//			String sql = SQL_QUERY2 + "'" + qcity + "'";
//			System.out.println(sql);
			
			
			pstmt.setString(1, qcity);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String c1 =  rs.getString("id");
				String c2 =  rs.getString("city");
				String c3 =  rs.getString("name");
				System.out.printf("%s:%s:%s\n", c1, c2, c3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
