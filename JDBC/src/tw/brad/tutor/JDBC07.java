package tw.brad.tutor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC07 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_INSERT = """
							INSERT INTO food
							(name, city, town, addr, tel, feature, picurl, lat, lng) 
							VALUES 
							(?,?,?,?,?,?,?,?,?)
							""";
	private static final String SQL_DEL_ALL = """
							DELETE FROM food
							""";
	private static final String SQL_ID_ZERO = """
							ALTER TABLE food AUTO_INCREMENT = 1
							""";

	public static void main(String[] args) {
		try {
			// 1. Client
			HttpClient client = HttpClient.newHttpClient();
			
			// 2. Request
			HttpRequest request = HttpRequest.newBuilder()
									.uri(URI.create("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx"))
									.GET()
									.build();
			
			// 3. send
			HttpResponse<String> response =
					client.send(request, HttpResponse.BodyHandlers.ofString());
		
			String body = response.body();
			parseJSON(body);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void parseJSON(String json) {
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");

		try (Connection conn = DriverManager.getConnection(URL,PROP);
					){
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(SQL_DEL_ALL);
			stmt.execute(SQL_ID_ZERO);
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			
			JSONArray root = new JSONArray(json);
			System.out.println(root.length());
			for (int i = 0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				
				String name = row.getString("Name");
				String city = row.getString("City");
				String town = row.getString("Town");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				String feature = row.getString("FoodFeature");
				String picurl = row.getString("PicURL");
				
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, city);
				pstmt.setString(3, town);
				pstmt.setString(4, addr);
				pstmt.setString(5, tel);
				pstmt.setString(6, feature);
				pstmt.setString(7, picurl);
				try {
					pstmt.setDouble(8, Double.parseDouble(lat));
					pstmt.setDouble(9, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(8, 0.0);
					pstmt.setDouble(9, 0.0);
					
				}
				
				pstmt.addBatch();
				
			}
			
			pstmt.executeBatch();
			System.out.println("Finish");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
