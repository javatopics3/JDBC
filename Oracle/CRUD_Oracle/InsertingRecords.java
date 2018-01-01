//package JDBC;
package CRUD_Oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertingRecords {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select rno,name,marks from students");
			rs.moveToInsertRow();
			rs.updateInt(1, 11);
			rs.updateString(2, "iii");
			rs.updateInt(3, 555);
			System.out.println("One record Inserted Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
