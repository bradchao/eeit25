package tw.brad.tutor;

public class JDBC01 {

	public static void main(String[] args) {
		try {
			// SQLserver: com.microsoft.sqlserver.jdbc.SQLServerDriver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
