package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.api.Bike;

public class JDBC16 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_QUERY = """
							SELECT *
							FROM member
							WHERE id = 1
							""";
	public static void main(String[] args) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
				FileOutputStream fout = new FileOutputStream("dir3/brad.png")
				){
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("icon");
				
				int len; byte[] buf = new byte[1024];
				while ((len = in.read(buf)) != -1) {
					fout.write(buf,0, len);
				}
				in.close();
				//------------------------
				InputStream bikeIn = rs.getBinaryStream("bike");
				ObjectInputStream oin = new ObjectInputStream(bikeIn);
				Object obj = oin.readObject();
				if (obj instanceof Bike) {
					Bike b1 = (Bike)obj;
					System.out.println(b1);
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
