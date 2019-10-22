package haushaltsbuch;

import java.sql.*;

public class SQLTest {
	
	private static Connection conn;
	private static boolean hasData = false;
	
	public ResultSet displayUsers() throws SQLException, ClassNotFoundException {
		if (conn == null) {
			getConnection();
		}
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT fname, lname FROM user");
		return res;
		
	}

	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:SQLTest1.db");
		initialise();
		
	}

	private void initialise() throws SQLException, ClassNotFoundException {
		if(!hasData) {
			hasData = true;
			
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user'");
			if(!res.next()) {
				Statement stmt2 = conn.createStatement();
				stmt2.execute("CREATE TABLE user (id integer, fname varchar(30), lname varchar(30), primary key(id));");
				
				PreparedStatement prepState = conn.prepareStatement("INSERT INTO user values (?,?,?);");
				prepState.setString(2, "Flo");
				prepState.setString(3, "Hoh");
				prepState.execute();
				
				PreparedStatement prepState2 = conn.prepareStatement("INSERT INTO user values (?,?,?);");
				prepState2.setString(2, "Hallo");
				prepState2.setString(3, "Du");
				prepState2.execute();
			}
		}
	}
	
	public void addUser(String firstname, String lastname) throws ClassNotFoundException, SQLException {
		
		if( conn==null) {
			getConnection();
		}
		
		PreparedStatement prepState = conn.prepareStatement("INSERT INTO users VALUES (?, ?, ?);");
		prepState.setString(2, firstname);
		prepState.setString(3, lastname);
		prepState.execute();
		
	}

}
