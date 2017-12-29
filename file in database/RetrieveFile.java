//Example to retrieve file from Oracle database
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Example to retrieve file from Oracle database
public class RetrieveFile {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");

			PreparedStatement ps = con
					.prepareStatement("select * from filetable");
			ResultSet rs = ps.executeQuery();
			rs.next();// now on 1st row

			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();

			FileWriter fw = new FileWriter("g:\\retrivefile.txt");

			int i;
			while ((i = r.read()) != -1)
				fw.write((char) i);

			fw.close();
			con.close();

			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
