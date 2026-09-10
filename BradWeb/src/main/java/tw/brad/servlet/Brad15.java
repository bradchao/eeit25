package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
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
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/brad?useSSL=false";
		String sql = """
				SELECT id, cname
				FROM cust
				""";
		try (Connection conn = dataSource.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				System.out.printf("%d:%s\n", rs.getLong("id"), rs.getString("cname"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
