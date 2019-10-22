package haushaltsbuch;

import java.sql.*;

public class SQLiteApp {

	public static void main(String[] args) {
			SQLTest test = new SQLTest();
			ResultSet rs;
			
			try {
				rs = test.displayUsers();
				while (rs.next()) {
					System.out.println(rs.getString("fname") + " " + rs.getString("lname"));
				}
			}
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				
				test.addUser("Paul", "Gaul");
				
			}
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

}
