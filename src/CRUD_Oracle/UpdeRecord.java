//package JDBC;
package CRUD_Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdeRecord {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
			ResultSet rs = stmt.executeQuery("select rno,name,marks from students");
			
			rs.absolute(1);//row no
			rs.updateInt(1, 5);
			rs.updateString(2, "BHASKAR");
			rs.updateInt(3, 93);
			rs.updateRow();
			System.out.println("One Record Updated Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
