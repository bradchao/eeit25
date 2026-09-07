package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.api.Bike;

public class JDBC15 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_UPDATE = """
							UPDATE member
							SET icon = ?, bike = ?
							WHERE id = ?
							""";
	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.println(b1);
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
				FileInputStream fin = new FileInputStream("dir2/ball2.png")){
			
			pstmt.setBinaryStream(1, fin);
			pstmt.setObject(2, b1);
			pstmt.setInt(3, 1);
			int n = pstmt.executeUpdate();
			System.out.println(n);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
