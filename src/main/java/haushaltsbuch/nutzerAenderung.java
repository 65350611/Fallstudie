package haushaltsbuch;

import java.sql.*;

public class nutzerAenderung {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public nutzerAenderung() {

	}

	private Connection getConnection() throws SQLException {
		Connection con;
		con = dbConnector.DriverManager.getConnection();
		return con;
	}

	public void add(nutzer nutzer) {
		try {
			String queryString = "INSERT INTO nutzer(userID, userRole, name, password) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, nutzer.getUserID());
			ptmt.setInt(2, nutzer.getUserRole());
			ptmt.setString(3, nutzer.getName());
			ptmt.setString(4, nutzer.getPassword());
			ptmt.executeUpdate();
			System.out.println("Nutzer erfolgreich hinzugefügt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void update(nutzer nutzer) {

		try {
			String queryString = "UPDATE nutzer SET roleLabel=? WHERE roleID=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, nutzer.getUserRole());
			ptmt.setInt(2, nutzer.getUserID());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void delete(int userID) {

		try {
			String queryString = "DELETE FROM nutzer WHERE userID=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, userID);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void findAll() {
		try {
			String queryString = "SELECT * FROM nutzer";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("userID " + resultSet.getInt("userID") + ", userRole " + resultSet.getInt("userRole") + ", name " + resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
