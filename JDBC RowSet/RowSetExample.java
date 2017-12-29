//Simple example of JdbcRowSet
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Creating and Executing RowSet
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rowSet.setUsername("system");
		rowSet.setPassword("manager");

		rowSet.setCommand("select * from emp400");
		rowSet.execute();

		while (rowSet.next()) {
			// Generating cursor Moved event
			System.out.println("Id: " + rowSet.getString(1));
			System.out.println("Name: " + rowSet.getString(2));
			System.out.println("Salary: " + rowSet.getString(3));
		}

	}
}
