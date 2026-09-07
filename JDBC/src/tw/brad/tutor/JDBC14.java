package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
SELECT o.EmployeeID, e.FirstName, e.LastName, SUM(od.UnitPrice*od.Quantity) sum 
FROM `orders` o
	JOIN employees e ON o.EmployeeID = e.EmployeeID
	JOIN orderdetails od ON o.OrderID = od.OrderID
GROUP BY o.EmployeeID
ORDER BY sum DESC
-----------------
+------------+-----------+-----------+-------------+
| EmployeeID | FirstName | LastName  | sum         |
+------------+-----------+-----------+-------------+
|          4 | Margaret  | Peacock   | 250187.4500 |
|          3 | Janet     | Leverling | 213051.3000 |
|          1 | Nancy     | Davolio   | 202143.7100 |
|          2 | Andrew    | Fuller    | 177749.2600 |
|          7 | Robert    | King      | 141295.9900 |
|          8 | Laura     | Callahan  | 133301.0300 |
|          9 | Anne      | Dodsworth |  82964.0000 |
|          6 | Michael   | Suyama    |  78198.1000 |
|          5 | Steven    | Buchanan  |  75567.7500 |
+------------+-----------+-----------+-------------+

 */
public class JDBC14 {
	private static final String URL = "jdbc:mysql://localhost:3306/north";
	private static final Properties PROP = new Properties();
	private static final String SQL_QUERY = """
							SELECT o.EmployeeID, e.FirstName, e.LastName, SUM(od.UnitPrice*od.Quantity) sum 
							FROM `orders` o
								JOIN employees e ON o.EmployeeID = e.EmployeeID
								JOIN orderdetails od ON o.OrderID = od.OrderID
							GROUP BY o.EmployeeID
							ORDER BY sum DESC
							""";
	public static void main(String[] args) {
		
		PROP.put("user", "root");
		PROP.put("password", "root");
		PROP.put("useSSL", "false");
		PROP.put("characterEncoding", "UTF-8");
		
		try (Connection conn = DriverManager.getConnection(URL,PROP);
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);){
			ResultSet rs = pstmt.executeQuery();
			int rank = 1;
			while (rs.next()) {
				System.out.printf("%d : %s %s : %s\n", rank++, 
						rs.getString("FirstName"), rs.getString("LastName"), rs.getString("sum"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		

	}

}
