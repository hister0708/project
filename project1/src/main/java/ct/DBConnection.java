package ct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/rese", "root", "1770");
		}catch(ClassNotFoundException e) { e.printStackTrace();}
		catch( SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

