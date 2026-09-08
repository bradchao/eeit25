package tw.brad.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcToolV2 {
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
		
		// MySQL 優化
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtsCacheSize", "250");
		
		dataSource = new HikariDataSource(config);
	}	
	
	public static <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...args){
		List<T> list = new ArrayList<T>();
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			if (args != null) {
				for (int i=0; i<args.length; i++) {
					pstmt.setObject(i+1, args[i]);
				}
			}
			
			try (ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					T row = rowMapper.mapRow(rs);
					list.add(row);
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static int update(String sql, Object...args) {
		int rows = 0;
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			if (args != null) {
				for (int i=0; i<args.length; i++) {
					pstmt.setObject(i+1, args[i]);
				}
			}
			
			rows = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public static void shutDown() {
		if (dataSource != null && !dataSource.isClosed()) {
			dataSource.close();
		}
	}
}
