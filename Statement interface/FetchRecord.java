import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FetchRecord {
	private static int result;

	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		Statement stmt = con.createStatement();

		result = stmt
				.executeUpdate("insert into emp765 values(33,'Irfan',50000)");
		// int
		// result=stmt.executeUpdate("update emp765 set name='Vimal',salary=10000 where id=33");
		// int result = stmt.executeUpdate("delete from emp765 where id=33");
		System.out.println(result + " records affected");
		con.close();
	}
}
