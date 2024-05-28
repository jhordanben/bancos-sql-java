package conexaojdbc2;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	public static String url = "jdbc:postgresql://localhost:5432/maroon";
	public static String password = "admin";
	public static String user = "postgres";
	public static Connection connection = null;
	
	static {
		conectar();
		
	}
	
	public static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("conectou");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
