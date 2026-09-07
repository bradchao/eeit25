package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.api.Food;

public class JDBC12 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_KEY = """
						SELECT id, name, city, town, addr, tel, feature
						FROM food
						WHERE name LIKE ? OR city LIKE ? OR town LIKE ? 
						OR addr LIKE ? OR feature LIKE ? OR tel LIKE ?
							""";
	public static void main(String[] args) {
		
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmt = conn.prepareStatement(SQL_KEY);
				){
			System.out.println("Food Search");
			System.out.println("-----");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Keyword: ");
			String key = scanner.next();
			System.out.println("-----");
			
			List<Food> foods = search(key, pstmt);
			for (Food food : foods) {
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	static List<Food> search(String key, PreparedStatement pstmt){
		List<Food> foods = new LinkedList<>();
		
		return foods;
	}
	

}
