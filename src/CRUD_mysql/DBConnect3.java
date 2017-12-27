package CRUD_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect3 {
	public static void main(String[] args) throws ClassNotFoundException {
		String databaseURL = "";
		String user = "";
		String password = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sampledb", "root", "");
			if (conn != null) {
				System.out.println("Connected to the database");
			}
		} catch (SQLException ex) {
			System.out
					.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}