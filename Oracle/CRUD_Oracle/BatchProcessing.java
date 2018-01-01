package CRUD_Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessing {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into students values(6,'Ravi',77)");
			stmt.addBatch("update students set marks=40 where rno=4");
			stmt.addBatch("delete from students where rno=2");
			stmt.executeBatch();
			System.out.println("Batch Executed Successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
