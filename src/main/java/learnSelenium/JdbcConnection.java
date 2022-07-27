package learnSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/dvdrental",
	            "postgres", "jeba123");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM actor limit 30;" );
	         while ( rs.next() ) {
		         int id = rs.getInt("actor_id");
		         String  first_name = rs.getString("first_name");
		         String  last_name = rs.getString("last_name");
		         String last_update = rs.getString("last_update");
		         System.out.println();
		         System.out.print( "ID = " + id );
		         System.out.print( "\tNAME = " + first_name + " " + last_name );
		         System.out.print("\t\t\tLast update = " + last_update);
	         }
	            rs.close();
	            stmt.close();
	            c.close();
	         }catch (Exception e) {
				e.printStackTrace();
			}
	      System.out.println();
	      System.out.println("Operation success!!");

	}
}
