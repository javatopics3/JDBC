//package JDBC;
package CRUD_Oracle;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			System.out.println("Connection Established Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
