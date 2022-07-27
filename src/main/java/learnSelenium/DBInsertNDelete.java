package learnSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInsertNDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental",
	            "postgres", "jeba123");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "insert into actor(first_name,last_name) values ('Jebin','Joseph');";
			
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("Row inserted");
			ResultSet result = stmt.executeQuery("select * from actor where first_name = 'Jebin';");
			while (result.next()) {
				System.out.println("First Name = " + result.getString("first_name") + " Last Name = " + result.getString("last_name"));
			}
			stmt.executeUpdate("delete from actor where first_name = 'Jebin';");
			conn.commit();
			System.out.println("Row deleted!!");
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
