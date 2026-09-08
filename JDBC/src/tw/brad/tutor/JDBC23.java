package tw.brad.tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBC23 {
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
	
	private static final String SQL = """
			SELECT id, name, city, town, tel, feature
			FROM food
			""";
	
	public static void main(String[] args) {
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					SQL,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pstmt.executeQuery()){
			rs.next();
			System.out.println(rs.getString("name"));
			
			rs.absolute(4);
			System.out.println(rs.getString("name"));
			rs.previous();
			System.out.println(rs.getString("name"));
			System.out.println("----");
			
			rs.absolute(17);
			System.out.println(rs.getString("name"));
			rs.updateString("feature", "很好吃的就對啦");
			rs.updateRow();
			
			rs.absolute(10);
			rs.deleteRow();
			
			rs.moveToInsertRow();
			rs.updateString("name", "不來的大餐廳");
			rs.updateString("city", "台中");
			rs.insertRow();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
