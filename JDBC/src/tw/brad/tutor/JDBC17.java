package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import tw.brad.api.Food;

public class JDBC17 {
	// Application => 共用 Connection Pool
	private static HikariDataSource dataSource;
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/brad");
		config.setUsername("root");
		config.setPassword("root");
		
		// 優化
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(4);
		config.setConnectionTimeout(10*1000);
		
		dataSource = new HikariDataSource(config);
	}
	
	
	private static final String SQL_KEY = """
						SELECT id, name, city, town, addr, tel
						FROM food
						ORDER BY id
						LIMIT ?, ?
							""";
	private static final int rpp = 10;
	
	public static void main(String[] args) {

		
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_KEY);
				){
			System.out.println("Food Search");
			System.out.println("-----");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Page: ");
			int page = scanner.nextInt();
			System.out.println("-----");
//			
//			String skey = "%" + key + "%";
			
			List<Food> foods = search(page, pstmt);
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
	
	static List<Food> search(int page, PreparedStatement pstmt)throws Exception{
		List<Food> foods = new LinkedList<>();

		int start = (page - 1) * rpp;
		
		pstmt.setInt(1, start);
		pstmt.setInt(2, rpp);
		
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
