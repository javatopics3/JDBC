//package JDBC;
package CRUD_Oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteRecord {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select rno,name,marks from students");
			rs.absolute(1);
			rs.deleteRow();
			System.out.println("One Record Deleted Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
