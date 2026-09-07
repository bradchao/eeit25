package tw.brad.tutor;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
