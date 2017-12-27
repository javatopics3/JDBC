//package JDBC;
package CRUD_Oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement();
			stmt.execute("create table students(rno number(3),name varchar2(10),marks number(3))");
			System.out.println("Table Cre1ated Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
