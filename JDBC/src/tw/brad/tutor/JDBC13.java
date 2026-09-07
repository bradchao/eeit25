package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.api.Food;

public class JDBC13 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final Properties PROP = new Properties();
	private static final String SQL_KEY = """
						SELECT id, name, city, town, addr, tel
						FROM food
						ORDER BY id
						LIMIT ?, ?
							""";
	public static void main(String[] args) {
		
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmt = conn.prepareStatement(SQL_KEY);
				){
//			System.out.println("Food Search");
//			System.out.println("-----");
//			Scanner scanner = new Scanner(System.in);
//			System.out.print("Keyword: ");
//			String key = scanner.next();
//			System.out.println("-----");
//			
//			String skey = "%" + key + "%";
			
			List<Food> foods = search(pstmt);
			System.out.printf("共%d筆美食資料\n", foods.size());
			System.out.println("-----");
			for (Food food : foods) {
				System.out.printf("%d:%s:%s:%s\n", food.getId(), food.getName(), food.getTel(), food.getAddr());
				System.out.println("------------------------");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	static List<Food> search(PreparedStatement pstmt)throws Exception{
		List<Food> foods = new LinkedList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Food food = new Food(rs.getLong("id"), rs.getString("name"), 
					rs.getString("city")+rs.getString("town")+rs.getString("addr"),
					rs.getString("tel"),null);
			foods.add(food);
		}
		
		
		return foods;
	}
	

}
