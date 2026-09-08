package tw.brad.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTool {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...args){
		List<T> list = new ArrayList<T>();
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			for (int i=0; i<args.length; i++) {
				pstmt.setObject(i+1, args[i]);
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
	
}
