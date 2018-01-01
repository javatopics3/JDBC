//package JDBC;
package CRUD_Oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecord {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into students values(4,'ddd',99)");
			System.out.println("One Record Inserted Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
