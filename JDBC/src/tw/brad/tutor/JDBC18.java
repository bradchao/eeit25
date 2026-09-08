package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mysql.cj.util.DataTypeUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBC18 {
	private static final String URL_DB = "jdbc:mysql://localhost/north?user=root&password=root";
	private static final String SQL = """
							SELECT o.EmployeeID, e.FirstName, e.LastName, SUM(od.UnitPrice*od.Quantity) sum 
							FROM `orders` o
								JOIN employees e ON o.EmployeeID = e.EmployeeID
								JOIN orderdetails od ON o.OrderID = od.OrderID
							GROUP BY o.EmployeeID
							ORDER BY sum DESC			
							""";
	private static HikariDataSource dataSource;
	private static final int TOTAL_THREADS = 10;
	private static final int QUERYS_PER_THREAD = 1000;
	
	private static void init() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL_DB);
		
		config.setMaximumPoolSize(100);
		config.setMinimumIdle(10);
		config.setConnectionTimeout(10*1000);
		config.setIdleTimeout(30*1000);
		config.setPoolName("TestPool");
		
		dataSource = new HikariDataSource(config);
	}
	
	// 1. DriverManager
	private static Connection getConnectionFromDriverManager() throws SQLException {
		return DriverManager.getConnection(URL_DB);
	}
	
	// 2. HikariCP
	private static Connection getConnectionFromHikari() throws SQLException {
		return dataSource.getConnection();
	}
	
	@FunctionalInterface
	interface ConnectionSupplier {
		Connection get() throws SQLException;
	}
	
	
	private static void runTest(String testName, ConnectionSupplier supplier) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(TOTAL_THREADS);
		CountDownLatch latch = new CountDownLatch(TOTAL_THREADS);
		
		long start = System.currentTimeMillis();
		
		for (int i=0; i<TOTAL_THREADS; i++) {
			executor.submit(() -> {
				try {
					for (int j = 0; j< QUERYS_PER_THREAD; j++) {
						try (Connection conn = supplier.get();
								PreparedStatement pstmt = conn.prepareStatement(SQL);
								ResultSet rs = pstmt.executeQuery();
								){
							
							while(rs.next()) {
								int id = rs.getInt("id");
								double sum = rs.getDouble("sum");
							}
						}
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					latch.countDown();
				}
			});
		}
		
		latch.await();
		executor.shutdown();
		long duration = System.currentTimeMillis() - start;
		
		System.out.printf("%s: %d \n", testName, duration);
		
		
		/*
		new Thread(()->{
			
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				// Java I/O
			}
		}).start();
		*/
		
		
	}
	
	public static void main(String[] args) {
		init();
	}

}
