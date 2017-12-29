/*In this example, 
 * we are going to call the 
 * stored procedure 
 * INSERTR that receives id and name 
 * as the parameter and inserts it into 
 * the table user420. 
 * Note that you need to create 
 * the user420 table as well 
 * to run this application.
 */import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Proc {
	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");

		CallableStatement stmt = con.prepareCall("{call insertR(?,?)}");
		stmt.setInt(1, 1011);
		stmt.setString(2, "Amit");
		stmt.execute();

		System.out.println("success");
	}
}
